package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author 王佳鹏
 * @Date 2022/2/16 20:00
 * @Description
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "1、PaymentFallbackService的paymentInfo_OK提示你出错了";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "2、PaymentFallbackService的paymentInfo_TimeOut提示你出错了";
    }
}
