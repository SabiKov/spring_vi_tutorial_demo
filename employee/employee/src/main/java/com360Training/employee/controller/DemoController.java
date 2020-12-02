package com360Training.employee.controller;

import com360Training.employee.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;

@Controller
public class DemoController {


    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        String message = demoService.sayHello().toUpperCase();
        if(message != null)
            return message.toUpperCase();

        return "";
    }
}
