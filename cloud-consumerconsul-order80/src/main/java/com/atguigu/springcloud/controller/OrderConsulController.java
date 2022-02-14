package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author 王佳鹏
 * @Date 2022/2/14 16:38
 * @Description
 */
@RestController
public class OrderConsulController {
    public static final String INVOKE_URL="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String result= restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }

}
