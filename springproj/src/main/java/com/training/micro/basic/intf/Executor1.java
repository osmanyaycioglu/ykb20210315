package com.training.micro.basic.intf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("en")
public class Executor1 implements IExecutor {

    @Override
    public String exec(final String strParam) {
        return "Executor Hello " + strParam;
    }

}
