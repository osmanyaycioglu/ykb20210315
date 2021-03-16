package com.training.micro.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MyRestController {

    @GetMapping("/hello/{isim}")
    public String hello(@PathVariable("isim") final String name) {
        return "Hello " + name;
    }

    @PostMapping("/hello/{isim}")
    public String hello2(@PathVariable("isim") final String name) {
        return "Hello POST " + name;
    }

    @PutMapping("/hello/{isim}")
    public String hello3(@PathVariable("isim") final String name) {
        return "Hello PUT " + name;
    }

    @PatchMapping("/hello/{isim}")
    public String hello4(@PathVariable("isim") final String name) {
        return "Hello PATCH " + name;
    }

    @DeleteMapping("/hello/{isim}")
    public String hello5(@PathVariable("isim") final String name) {
        return "Hello DELETE " + name;
    }

}
