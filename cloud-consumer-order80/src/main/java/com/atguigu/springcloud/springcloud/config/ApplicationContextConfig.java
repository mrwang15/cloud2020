package com.atguigu.springcloud.springcloud.config;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 王佳鹏
 * @Date 2022/2/10 19:27
 * @Description
 */
@Configuration
public class ApplicationContextConfig {
    //这里注释是想要使用自己写的轮训算法
    //@LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
