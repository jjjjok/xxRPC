package com.myrpc.test.client;

import com.myprc.serializer.CommonSerializer;
import com.myprc.socket.SocketClient;
import com.myprc.utils.RpcClientProxy;
import com.myrpc.api.HelloObject;
import com.myrpc.api.HelloService;

public class SocketClientTest {
    public static void main(String[] args) {
        SocketClient client = new SocketClient(CommonSerializer.KRYO_SERIALIZER);
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(1314, "通过Socket传来的消息");
        for(int i = 0; i < 20; i ++) {
            String res = helloService.hello(object);
            System.out.println(res);
        }
    }

    }

