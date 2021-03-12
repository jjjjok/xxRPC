package com.myrpc.test.server;


import com.myprc.annotation.Service;
import com.myrpc.api.HelloObject;
import com.myrpc.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class HelloServiceImpl implements HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);


    public String hello(HelloObject object) {
        logger.info("服务器接收到客户端信息：{}", object.getMessage());
        return "客户端接收的返回值，id=" + object.getId();

    }
}
