package com.myrpc.test.server;

import com.myprc.netty.server.NettyServer;
import com.myprc.registry.ServiceRegistry;
import com.myprc.registry.ServiceRegistryImpl;
import com.myrpc.api.HelloService;
import com.myrpc.api.HelloServiceImpl;

public class NettyServerTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry registry = new ServiceRegistryImpl();
        registry.register(helloService);
        NettyServer server = new NettyServer();
        server.start(9999);
    }
}
