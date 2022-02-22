package com.atguigu.springcloud.springcloud.controller;


import com.atguigu.springcloud.springcloud.entities.CommonResult;
import com.atguigu.springcloud.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 王佳鹏
 * @Date 2022/2/10 19:19
 * @Description
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMNET_URL ="http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMNET_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMNET_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/getForEntity/get/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMNET_URL + "/payment/get/" + id, CommonResult.class);
        log.info(forEntity.getStatusCode().toString());
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }
        else {
            return new CommonResult<>(444,"运行失败");
        }
    }

}
