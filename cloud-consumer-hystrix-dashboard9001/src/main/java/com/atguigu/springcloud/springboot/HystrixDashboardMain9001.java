package com.atguigu.springcloud.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author 王佳鹏
 * @Date 2022/2/17 11:54
 * @Description
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
