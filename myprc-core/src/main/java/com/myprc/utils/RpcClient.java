package com.myprc.utils;

import com.myprc.serializer.CommonSerializer;
import com.myrpc.common.entity.RpcRequest;

public interface RpcClient {
    Object sendRequest(RpcRequest rpcRequest);

    void setSerializer(CommonSerializer serializer);
}
