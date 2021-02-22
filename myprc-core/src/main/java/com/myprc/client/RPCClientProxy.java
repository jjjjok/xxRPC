package com.myprc.client;

import com.myrpc.common.entity.RPCRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RPCClientProxy implements InvocationHandler {
    private static final Logger logger = LoggerFactory.getLogger(RPCClientProxy.class);
    private String host;
    private int port;
    public RPCClientProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("调用方法: {}#{}", method.getDeclaringClass().getName(), method.getName());
        RPCRequest rpcRequest = RPCRequest.builder()
                .interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameters(args)
                .paramTypes(method.getParameterTypes())
                .build();
        RPCClient rpcClient = new RPCClient();
        return rpcClient.sendRequest(rpcRequest, host, port);
    }

}
