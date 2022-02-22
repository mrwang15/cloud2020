package com.atguigu.springcloud.springcloud.controller;

import com.atguigu.springcloud.springcloud.entities.CommonResult;
import com.atguigu.springcloud.springcloud.entities.Payment;
import com.atguigu.springcloud.springcloud.service.PaymentService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author 王佳鹏
 * @Date 2022/2/10 16:46
 * @Description
 */
@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

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

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                String serviceId = instance.getServiceId();
                String host = instance.getHost();
                int port = instance.getPort();
                URI uri = instance.getUri();
                log.info("姓名 : {} host: {} port : {}  uro:  {}",serviceId,host,port,uri);

            }

        }


        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }


    @GetMapping(value="/payment/feign/timeout")
    public String paymentFeginTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


}
