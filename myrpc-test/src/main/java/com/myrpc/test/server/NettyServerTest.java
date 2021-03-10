package com.myrpc.test.server;

import com.myprc.netty.server.NettyServer;
import com.myprc.serializer.CommonSerializer;
import com.myrpc.api.HelloService;
import com.myrpc.api.HelloServiceImpl;

public class NettyServerTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        NettyServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        server.publishService(helloService, HelloService.class);
    }
}
