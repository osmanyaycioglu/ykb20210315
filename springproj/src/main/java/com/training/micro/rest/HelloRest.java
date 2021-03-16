package com.training.micro.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloRest {

    @GetMapping("/1/{abc}/soy/{xyz}/yas/{qwe}")
    public String helloHanlde(@PathVariable("abc") final String name,
                              @PathVariable("xyz") final String surname,
                              @PathVariable("qwe") final Integer age) {
        return "Hello 1 " + name + " " + surname + " " + age;
    }

    @GetMapping("/2")
    public String helloHanlde2(@RequestParam("abc") final String name,
                               @RequestParam("xyz") final String surname,
                               @RequestParam("qwe") final Integer age) {
        return "Hello 2 " + name + " " + surname + " " + age;
    }

    @GetMapping("/3/{abc}")
    public String helloHanlde3(@PathVariable("abc") final String name,
                               @RequestParam("xyz") final String surname,
                               @RequestParam("qwe") final Integer age) {
        return "Hello 2 " + name + " " + surname + " " + age;
    }

    // Wrong
    @GetMapping("/4/{abc}")
    public String helloHanlde4(@PathVariable("abc") final String op,
                               final HttpServletRequest htr) {
        switch (op) {
            case "add":
                Object attributeLoc = htr.getAttribute("test");
                break;
            default:
                break;
        }
        return op;
    }

}

