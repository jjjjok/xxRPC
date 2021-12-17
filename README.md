# MouRPC
某不知名rpc练手项目
基于Netty与Nacos实现的RPC框架。实现了基于Java原生Socket与Netty的两种网络传输方式，并且自定义了序列化与负载均衡算法。
## 项目要点
 - 完成了RPC框架所具备的基本功能：如服务发现注册，负载均衡，序列化传输，动态代理等
 - 实现了两种方式的网络传输，分别是基于Java原生Socket的方式和基于Netty框架的方式。
 - 实现了4种序列化方式，分别是Json，Kyro，Hessian，Protostuff四种方式
 - 使用Nacos进行服务发现与注册，有服务传入时连接到Nacos，并且在服务退出后注销服务
 - 实现了两种负载均衡算法：随机选择算法与轮转算法
 - 支持以注解方式完成服务注册
 - 自定义传输协议与编码、解码器，完成了客户端与服务端之间的数据传输
 ## 文件结构
  - myrpc-api——通用接口
  - myrpc-common——1.工具类，如异常处理工具类，nacos工具类，单例工厂工具类等    2.实体对象RpcRequest与RPCResponse
  - myrpc-core——核心实现类
  - myrpc-test——客户端与服务端测试类
 

 ## 启动
 **运行前需启动nacos服务**
 
 创建服务端实例，可指定序列化器，当然是可以创建多个服务端的，服务发现时就会使用负载均衡算法
 ```java
package com.myrpc.test.server;

import com.myprc.annotation.ServiceScan;
import com.myprc.netty.server.NettyServer;
import com.myprc.serializer.CommonSerializer;

@ServiceScan
public class NettyServerTest {
    public static void main(String[] args) {
        NettyServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        NettyServer server1 = new NettyServer("127.0.0.1", 9990, CommonSerializer.PROTOBUF_SERIALIZER);
        server.start();
        server1.start();
    }
}
 ```
创建客户端实例，指定序列化器与负载均衡算法
 ```java
package com.myrpc.test.client;

import com.myprc.netty.client.NettyClient;
import com.myprc.serializer.CommonSerializer;
import com.myprc.utils.RpcClient;
import com.myprc.utils.RpcClientProxy;
import com.myrpc.api.HelloObject;
import com.myrpc.api.HelloService;

public class NettyClientTest {
    public static void main(String[] args) {
        RpcClient client = new NettyClient(CommonSerializer.PROTOBUF_SERIALIZER，new RandomLoadBalancer());
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(1314, "通过Netty传来的消息");
        String res = helloService.hello(object);
        System.out.println(res);
}
 ```
