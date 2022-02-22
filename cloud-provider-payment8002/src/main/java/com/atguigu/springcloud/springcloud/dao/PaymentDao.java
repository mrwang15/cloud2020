package com.atguigu.springcloud.springcloud.dao;

import com.atguigu.springcloud.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 王佳鹏
 * @Date 2022/2/10 15:28
 * @Description
 */
@Mapper
public interface PaymentDao {
    //添加数据
    int create(Payment payment);

    //读数据
    Payment getPaymentById(@Param("id") Long id);


}
