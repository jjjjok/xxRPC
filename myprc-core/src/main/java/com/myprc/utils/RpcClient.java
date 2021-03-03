package com.myprc.utils;

import com.myrpc.common.entity.RpcRequest;

public interface RpcClient {
    Object sendRequest(RpcRequest rpcRequest);
}
