FROM nginx

USER root

COPY ./amq_stream.conf /etc/nginx/

COPY ./default.conf /etc/nginx/conf.d/default.conf

RUN echo 'include /etc/nginx/amq_stream.conf;' >> /etc/nginx/nginx.conf