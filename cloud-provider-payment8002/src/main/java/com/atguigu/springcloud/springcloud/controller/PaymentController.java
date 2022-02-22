package com.atguigu.springcloud.springcloud.controller;

import com.atguigu.springcloud.springcloud.entities.CommonResult;
import com.atguigu.springcloud.springcloud.entities.Payment;
import com.atguigu.springcloud.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 王佳鹏
 * @Date 2022/2/10 16:46
 * @Description
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PaymentService paymentService;


    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result>0){
            return new CommonResult(200,"插入数据库成功"+serverPort,result);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById !=null){
            return  new CommonResult(200,"查询成功"+serverPort,paymentById);
        }else {
            return new CommonResult(444,"查询失败");
        }

    }

    @GetMapping("/payment/discovery")
    public void discover(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("服务是"+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("id是 {} host是：{} port是 ：{} uri是： {}",
                        instance.getInstanceId(),instance.getHost(),instance.getPort(),instance.getUri());
            }


        }


    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

}
