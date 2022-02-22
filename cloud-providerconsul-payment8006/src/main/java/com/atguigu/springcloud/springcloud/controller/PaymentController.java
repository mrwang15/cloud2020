package com.atguigu.springcloud.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author 王佳鹏
 * @Date 2022/2/12 20:14
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String severPort;

    @GetMapping("/payment/consul")
    public String paymentInfo(){
        return "springcloud with consul:"+severPort+ UUID.randomUUID().toString();
    }


}
