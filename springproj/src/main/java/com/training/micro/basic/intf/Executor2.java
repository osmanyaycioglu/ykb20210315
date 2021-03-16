package com.training.micro.basic.intf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tr")
public class Executor2 implements IExecutor {

    @Override
    public String exec(final String strParam) {
        return "Executor Merhaba " + strParam;
    }

}
