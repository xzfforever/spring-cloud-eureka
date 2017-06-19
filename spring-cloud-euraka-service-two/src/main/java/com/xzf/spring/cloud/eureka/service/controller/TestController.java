package com.xzf.spring.cloud.eureka.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/19.
 */
@RestController
@RequestMapping(value = "/user")
public class TestController {

    @GetMapping(value = "/{id}")
    public String getUserInfoById(@PathVariable(value="id") String userId){
        //根据id,查user信息
        return "xiezhefeng";
    }

}
