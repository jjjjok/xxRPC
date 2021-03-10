package com.myprc.registry;

import java.net.InetSocketAddress;


//Nacos服务注册接口
public interface ServiceRegistry {
    void register(String serviceName, InetSocketAddress inetSocketAddress);


}
