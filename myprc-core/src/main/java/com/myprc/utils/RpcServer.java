package com.myprc.utils;

import com.myprc.serializer.CommonSerializer;

public interface RpcServer {
    void start();

    void setSerializer(CommonSerializer serializer);


    <T> void publishService(Object service, Class<T> serviceClass);
}
