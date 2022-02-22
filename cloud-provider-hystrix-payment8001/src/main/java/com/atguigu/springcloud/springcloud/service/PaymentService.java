package com.atguigu.springcloud.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 王佳鹏
 * @Date 2022/2/16 14:51
 * @Description
 */
public interface PaymentService {
     String paymentInfo_OK(Integer id);
     String paymentInfo_TimeOut(Integer id);
     String paymentCircuitBreaker(@PathVariable("id") Integer id);

}
