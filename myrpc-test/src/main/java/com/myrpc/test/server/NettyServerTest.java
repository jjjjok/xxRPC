package com.myrpc.test.server;

import com.myprc.annotation.ServiceScan;
import com.myprc.netty.server.NettyServer;
import com.myprc.serializer.CommonSerializer;

@ServiceScan
public class NettyServerTest {
    public static void main(String[] args) {
        NettyServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        server.start();
    }
}
