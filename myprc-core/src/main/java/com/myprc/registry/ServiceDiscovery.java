package com.myprc.registry;

import java.net.InetSocketAddress;


//Nacos服务发现接口
public interface ServiceDiscovery {
    InetSocketAddress lookupService(String serviceName);
}
