package com.training.micro.order.listeners;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class NotifyReqResponse {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "not-sms-res",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "not-exchange",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "not-sms-res-b"))
    public void handleEvent(final String str) {
        System.out.println("Received : " + str);
    }


}
