package com.jeekite.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class Demo {



    @RequestMapping("/test1")
    public String test1(){
        return "hello world  12333333";
    }
}
