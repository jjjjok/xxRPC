package com.myrpc.test.client;

import com.myprc.netty.client.NettyClient;
import com.myprc.utils.RpcClient;
import com.myprc.utils.RpcClientProxy;
import com.myrpc.api.HelloObject;
import com.myrpc.api.HelloService;

public class NettyClientTest {
    public static void main(String[] args) {
        RpcClient client = new NettyClient("127.0.0.1", 9999);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);

    }
}
