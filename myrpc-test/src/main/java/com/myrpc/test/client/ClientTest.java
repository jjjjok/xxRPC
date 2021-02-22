package com.myrpc.test.client;

import com.myprc.client.RPCClientProxy;
import com.myrpc.api.HelloObject;
import com.myrpc.api.HelloService;

public class ClientTest {
    public static void main(String[] args) {
        RPCClientProxy proxy = new RPCClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "这是客户端传来的消息");
        String res = helloService.hello(object);
        System.out.println(res);

    }
}
