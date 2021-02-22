package com.myrpc.common.entity;

import com.myrpc.common.info.ResponseCode;
import lombok.Data;

import java.io.Serializable;
@Data
//服务端调用后返回给客户端的信息
public class RPCResponse<T> implements Serializable {
    //响应状态码
    private Integer statusCode;

    //响应状态补充信息
    private String message;

    //响应数据
    private T data;

    public static <T> RPCResponse<T> success(T data) {
        RPCResponse<T> response = new RPCResponse<>();
        response.setStatusCode(ResponseCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static <T> RPCResponse<T> fail(ResponseCode code) {
        RPCResponse<T> response = new RPCResponse<>();
        response.setStatusCode(code.getCode());
        response.setMessage(code.getMessage());
        return response;
    }
}
