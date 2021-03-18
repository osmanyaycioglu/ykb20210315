package com.training.micro.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.error.MyRestClientException;
import com.training.micro.order.models.Order;
import com.training.micro.order.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1/management/order")
@RefreshScope
public class OrderController {

    @Autowired
    private OrderService os;

    @Value("${a.b.e}")
    private String       testStr;

    @GetMapping("/test")
    public String test() {
        return this.testStr;
    }

    @PostMapping("/place")
    @Operation(description = "Place order api method", method = "POST", summary = "sum place order", tags = "order")
    public String placeOrder(@Validated @RequestBody final Order order) {
        return this.os.placeOrder(order);
    }

    @PostMapping("/place2")
    @Operation(description = "Place order api method 2", method = "POST", summary = "sum place order 2", tags = "order")
    @ApiResponse(description = "dönüşte order açıklaması gelecek")
    public String placeOrder2(@Validated @RequestBody final Order order) throws MyRestClientException {
        return this.os.placeOrder2(order);
    }

}
