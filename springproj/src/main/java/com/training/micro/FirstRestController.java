package com.training.micro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world rest";
    }

}
