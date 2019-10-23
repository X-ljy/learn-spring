package com.ljy.qx.learnaop.controller;

import com.ljy.qx.learnaop.annotation.LogAnnoatation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;

/**
 * @author : 夕
 * @date : 2019/10/23
 */

@RestController
public class TestController {

    @LogAnnoatation(value = "注解调用")
    @GetMapping("/aop")
    public String TestAop(){
        System.out.println("TestAop Controller 调用");
        String s = new String ("test AOP");
        return s;
    }
}
