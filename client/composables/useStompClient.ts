import {Client} from 'stompjs';
import {useNuxtApp} from '#imports';

export const useStompClient = <T>() => {
    return useNuxtApp().$stomp.client;
}