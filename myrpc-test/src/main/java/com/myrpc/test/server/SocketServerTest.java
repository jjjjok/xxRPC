package com.myrpc.test.server;

import com.myprc.registry.ServiceRegistry;
import com.myprc.registry.ServiceRegistryImpl;
import com.myprc.socket.SocketServer;
import com.myrpc.api.HelloService;
import com.myrpc.api.HelloServiceImpl;


public class SocketServerTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new ServiceRegistryImpl();
        serviceRegistry.register(helloService);
        SocketServer socketServer = new SocketServer(serviceRegistry);
        socketServer.start(9000);

    }
}
