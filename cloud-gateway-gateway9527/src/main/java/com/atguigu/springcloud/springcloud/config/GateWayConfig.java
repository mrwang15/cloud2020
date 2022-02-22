package com.atguigu.springcloud.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 王佳鹏
 * @Date 2022/2/17 15:35
 * @Description
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes= builder.routes();
        routes.route("path_route_atguigu2",r->r.path("/guonei").uri("http://news.baidu.com")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder bulider){
        RouteLocatorBuilder.Builder routes = bulider.routes();
        routes.route("jingdong",e->e.path("/10-124.html").uri("https://phat.jd.com"));
        return routes.build();

    }
}
