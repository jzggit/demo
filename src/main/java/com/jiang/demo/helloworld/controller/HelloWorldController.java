package com.jiang.demo.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jiang")
public class HelloWorldController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value="name",required=false) String name){
        return name+"说：你好世界！";
    }
}
