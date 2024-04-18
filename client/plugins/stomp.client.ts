import {Client} from '@stomp/stompjs';
import { defineNuxtPlugin, useRuntimeConfig, useCookie } from '#app';

function connectCallback(frame: any) {

}

function errorCallback() {
    alert("error connecting to message queue");
}

export default defineNuxtPlugin({
    name: "stomp",
    async setup() {
        const host = "ws://localhost:61614";
        const myclient = new Client(
            {brokerURL: host, onConnect: connectCallback, debug: function(str) {
                console.log("STOMP " + str);
            }, reconnectDelay: 200}
        );
        myclient.activate();

        return {
            provide: {
                stomp: {
                    client: myclient
                }
            }
        }
    }
})