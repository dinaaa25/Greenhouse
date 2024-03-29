package com.botanic.deviceManager;


import com.botanic.deviceManager.model.Device;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@EnableJms
@Configuration
public class JmsConfiguration {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JmsConfiguration.class);
    // print errors and info via logger on the console, instead of system.out.print to set only for errors or disable it or etc.

    @Value("${activemq.broker-url}")
    private String brokerUrl;
    // messageQueue is also called broker

    @Value("${activemq.broker-username}")
    private String brokerUsername;

    @Value("${activemq.broker-password}")
    private String brokerPassword;

    private final ResourceLoader resourceLoader;

    @Autowired
    public JmsConfiguration(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * Connect JMS to an external ActiveMQ session, based on the active.broker-url of application.properties
     */
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();

        activeMQConnectionFactory.setBrokerURL(brokerUrl);

        log.info("Connect to ActiveMQ host: {}", brokerUrl);

        if(brokerUsername != null && !brokerUsername.isEmpty() && brokerPassword != null && !brokerPassword.isEmpty()) {
            activeMQConnectionFactory.setUserName(brokerUsername);
            activeMQConnectionFactory.setPassword(brokerPassword);
        }

        return activeMQConnectionFactory;
    }


    // adding jackson to jms
    // because jackson can convert json to object and vice and versa and jms can send this so we need both to send json to activemq
    @Bean
    public MessageConverter jsonMarshaller() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();

        Map<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("JMS_TYPE", Device.class);

        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("JMS_TYPE");
        converter.setObjectMapper(new ObjectMapper().findAndRegisterModules());


        return converter;
    }


    /**
     * Create the JmsListernerFactory with the correct marshaller.
     */
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory());
        factory.setMessageConverter(jsonMarshaller());
        factory.setConcurrency("3-10"); // limit concurrent listener
        factory.setErrorHandler((e) -> {
            log.error("An error occured while processing the MQ message", e);
        });

        return factory;
    }

}
