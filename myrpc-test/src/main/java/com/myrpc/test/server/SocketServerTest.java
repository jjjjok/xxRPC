package com.myrpc.test.server;

import com.myprc.annotation.ServiceScan;
import com.myprc.serializer.CommonSerializer;
import com.myprc.socket.SocketServer;
import com.myprc.utils.RpcServer;

@ServiceScan
public class SocketServerTest {
    public static void main(String[] args) {
        RpcServer server = new SocketServer("127.0.0.1", 9998, CommonSerializer.HESSIAN_SERIALIZER);
        server.start();

    }
}
