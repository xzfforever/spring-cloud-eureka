package com.xzf.spring.cloud.eureka.service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value="/item")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/user/info")
    public String getItemUserInfo() throws Exception{
        List<ServiceInstance>  serviceInstanceList = discoveryClient.getInstances("user-center");
        if(CollectionUtils.isEmpty(serviceInstanceList)){
            throw new Exception("Service Not Found");
        }
        ServiceInstance itemCenterService = serviceInstanceList.get(0);
        String url = itemCenterService.getUri()+"/user/12345";
        String userInfo = restTemplate.getForObject(url,String.class);
        return userInfo;
    }


}
