package com.myrpc.test.client;

import com.myprc.netty.client.NettyClient;
import com.myprc.serializer.CommonSerializer;
import com.myprc.utils.RpcClient;
import com.myprc.utils.RpcClientProxy;
import com.myrpc.api.HelloObject;
import com.myrpc.api.HelloService;

public class NettyClientTest {
    public static void main(String[] args) {
        RpcClient client = new NettyClient(CommonSerializer.PROTOBUF_SERIALIZER);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(1314, "通过Netty传来的消息");
        String res = helloService.hello(object);
        System.out.println(res);
}
}
