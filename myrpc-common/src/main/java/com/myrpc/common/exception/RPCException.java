package com.myrpc.common.exception;

import com.myrpc.common.info.RPCError;

public class RPCException extends RuntimeException{
    public RPCException(RPCError error, String detail) {
        super(error.getMessage() + ": " + detail);
    }

    public RPCException(String message, Throwable cause) {
        super(message, cause);
    }

    public RPCException(RPCError error) {
        super(error.getMessage());
    }
}
