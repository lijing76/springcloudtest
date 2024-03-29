package com.jing.springcloudtest.controller;

import com.jing.springcloudtest.entities.CommonResult;
import com.jing.springcloudtest.entities.Payment;
import com.jing.springcloudtest.service.PaymentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入数据:"+payment.getSerial());
        log.info("***** 插入结果："+result);

        if(result>0){
            return new CommonResult(200,"插入数据库成功, serverPort:"+ serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);

        if(null != payment){
            return new CommonResult(200,"读取数据库成功, serverPort:"+ serverPort,payment);
        }else{
            return new CommonResult(444,"读取数据库失败",null);
        }
    }

    @GetMapping(value="/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    @GetMapping(value="/payment/zipkin")
    public String paymentZipkin(){
        return "hi, I'm paymentzipkin server fallback, welcome to jingtest";
    }
}
