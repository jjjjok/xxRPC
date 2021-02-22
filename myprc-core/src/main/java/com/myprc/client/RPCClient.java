package com.myprc.client;

import com.myrpc.common.entity.RPCRequest;
import com.myrpc.common.entity.RPCResponse;
import com.myrpc.common.exception.RPCException;
import com.myrpc.common.info.RPCError;
import com.myrpc.common.info.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class RPCClient {
    private static final Logger logger = LoggerFactory.getLogger(RPCClient.class);
    public Object sendRequest(RPCRequest rpcRequest,String host,int port){
        try(Socket socket = new Socket(host,port)){

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            objectOutputStream.flush();
            RPCResponse rpcResponse = (RPCResponse)objectInputStream.readObject();

            if(rpcResponse == null) {
                logger.error("服务调用失败，service：{}", rpcRequest.getInterfaceName());
                throw new RPCException(RPCError.SERVICE_INVOCATION_FAILURE, " service:" + rpcRequest.getInterfaceName());
            }
            if(rpcResponse.getStatusCode() == null || rpcResponse.getStatusCode() != ResponseCode.SUCCESS.getCode()) {
                logger.error("调用服务失败, service: {}, response:{}", rpcRequest.getInterfaceName(), rpcResponse);
                throw new RPCException(RPCError.SERVICE_INVOCATION_FAILURE, " service:" + rpcRequest.getInterfaceName());
            }
            return rpcResponse.getData();

        }
        catch (IOException | ClassNotFoundException e) {
            logger.error("调用时有错误发生：", e);
            throw new RPCException("服务调用失败: ", e);
        }
    }
}
