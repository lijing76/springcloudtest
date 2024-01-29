package com.jing.springcloudtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class ConsumerMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @Bean
    public Consumer<String> myChannel(){
        return message -> log.info("Port:"+ serverPort + "\t"+"收到消息：" + message);
    }
}
