package com.training.micro;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "not-sms", durable = "true", autoDelete = "false"),
                                             exchange = @Exchange(name = "not-exchange",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "not-sms-b"))
    @SendTo("not-exchange/not-sms-res-b")
    public String handleEvent(final NotificationRequest str) {
        System.out.println("Received : " + str);
        return "Notification SMS SUCCESS : " + str;
    }


}
