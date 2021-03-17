package com.training.micro.order.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.micro.order.models.Order;
import com.training.micro.order.models.PaymetRequest;

@Service
public class OrderService {

    @Autowired
    private RestTemplate rt;

    @Autowired
    private EurekaClient eurekaClient;

    public String placeOrder(final Order orderParam) {
        PaymetRequest paymetRequestLoc = new PaymetRequest();
        paymetRequestLoc.setCustomer(orderParam.getCustomer());
        paymetRequestLoc.setCustomerId(orderParam.getCustomerId());
        paymetRequestLoc.setAmount(new BigDecimal(100));
        return this.rt.postForObject("http://ACCOUNTING/api/v1/payment/pay",
                                     paymetRequestLoc,
                                     String.class);
    }

    public String placeOrder3(final Order orderParam) {
        PaymetRequest paymetRequestLoc = new PaymetRequest();
        paymetRequestLoc.setCustomer(orderParam.getCustomer());
        paymetRequestLoc.setCustomerId(orderParam.getCustomerId());
        paymetRequestLoc.setAmount(new BigDecimal(100));
        Application applicationLoc = this.eurekaClient.getApplication("ACCOUNTING");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println();
        }

        InstanceInfo in = this.eurekaClient.getNextServerFromEureka("ACCOUNTING",
                                                                    false);
        RestTemplate templateLoc = new RestTemplate();
        return templateLoc.postForObject("http://" + in.getIPAddr() + ":" + in.getPort() + "/api/v1/payment/pay",
                                         paymetRequestLoc,
                                         String.class);
    }

}
