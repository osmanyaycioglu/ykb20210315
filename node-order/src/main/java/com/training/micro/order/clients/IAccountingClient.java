package com.training.micro.order.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.micro.error.MyRestClientException;
import com.training.micro.order.models.PaymetRequest;

@FeignClient("ACCOUNTING")
@RequestMapping("/api/v1/payment")
public interface IAccountingClient {

    @PostMapping("/pay")
    public String pay(@RequestBody final PaymetRequest pr) throws MyRestClientException;

}
