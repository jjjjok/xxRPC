package com.myrpc.test.server;

import com.myprc.serializer.CommonSerializer;
import com.myprc.socket.SocketServer;
import com.myrpc.api.HelloService;
import com.myrpc.api.HelloServiceImpl;


public class SocketServerTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketServer socketServer = new SocketServer("127.0.0.1", 9998, CommonSerializer.HESSIAN_SERIALIZER);
        socketServer.publishService(helloService, HelloService.class);

    }
}
