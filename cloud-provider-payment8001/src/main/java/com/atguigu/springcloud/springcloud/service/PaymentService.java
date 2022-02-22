package com.atguigu.springcloud.springcloud.service;

import com.atguigu.springcloud.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 王佳鹏
 * @Date 2022/2/10 15:54
 * @Description
 */
public interface PaymentService {
    int create(Payment pament);
    Payment getPaymentById(@Param("id") Long id);
}
