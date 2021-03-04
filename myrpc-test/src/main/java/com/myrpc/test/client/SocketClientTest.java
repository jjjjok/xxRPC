package com.myrpc.test.client;

import com.myprc.serializer.KryoSerializer;
import com.myprc.socket.SocketClient;
import com.myprc.utils.RpcClientProxy;
import com.myrpc.api.HelloObject;
import com.myrpc.api.HelloService;

public class SocketClientTest {
    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.setSerializer(new KryoSerializer());
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);

    }
}
