package com.training.micro.contollers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Value("${server.port}")
    private int port;

    @PostMapping("/pay")
    public String pay(@RequestBody final PaymetRequest pr) {
        return this.port + " - Payment Success : " + pr;
    }

}
