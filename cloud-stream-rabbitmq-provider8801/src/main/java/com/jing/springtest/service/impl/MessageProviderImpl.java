package com.jing.springtest.service.impl;

import com.jing.springtest.service.IMessageProvider;

import jakarta.annotation.Resource;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private StreamBridge streamBridge;

//    public MessageProviderImpl(StreamBridge streamBridge){
//        this.streamBridge = streamBridge;
//    }
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        streamBridge.send("myChannel-out-0", MessageBuilder.withPayload(serial).build());
        System.out.println("发送消息："+serial);
        return null;
    }
}
