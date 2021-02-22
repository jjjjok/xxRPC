package com.myrpc.test.server;

import com.myprc.registry.ServiceRegistry;
import com.myprc.registry.ServiceRegistryImpl;
import com.myprc.server.RPCServer;
import com.myrpc.api.HelloService;
import com.myrpc.api.HelloServiceImpl;


public class ServerTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new ServiceRegistryImpl();
        serviceRegistry.register(helloService);
        RPCServer rpcServer = new RPCServer(serviceRegistry);
        rpcServer.start(9000);

    }
}
