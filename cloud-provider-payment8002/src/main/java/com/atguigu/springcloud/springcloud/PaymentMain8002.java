package com.atguigu.springcloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author 王佳鹏
 * @Date 2022/2/10 15:04
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002
{
    public static void main(String[] args)
    {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
