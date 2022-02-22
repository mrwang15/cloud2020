package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;


import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author 王佳鹏
 * @Date 2022/2/22 19:16
 * @Description
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String message= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("******serial"+message);
        return message;
    }
}
