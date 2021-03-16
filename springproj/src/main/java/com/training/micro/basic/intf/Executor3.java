package com.training.micro.basic.intf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("es")
public class Executor3 implements IExecutor {

    @Override
    public String exec(final String strParam) {
        return "Executor Ola " + strParam;
    }

}
