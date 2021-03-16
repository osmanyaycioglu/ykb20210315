package com.training.micro.basic.intf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ExecutorConfig {

    @Autowired
    private Environment  env;

    @Value("${executor.type}")
    private int          execType;

    @Autowired
    private ExecutorProp ep;

    @Value("#{executorProp.type}")
    private Integer      eType;

    @Bean
    @Qualifier("auto")
    public IExecutor executorBean() {
        switch (this.eType) {
            case 1:
                return new Executor1();
            case 2:
                return new Executor2();
            case 3:
                return new Executor3();
            default:
                return new Executor1();
        }
    }

    @Bean
    @Qualifier("auto4")
    public IExecutor executorBean4() {
        switch (this.ep.getType()) {
            case 1:
                return new Executor1();
            case 2:
                return new Executor2();
            case 3:
                return new Executor3();
            default:
                return new Executor1();
        }
    }

    @Bean
    @Qualifier("auto3")
    public IExecutor executorBean3() {
        switch (this.execType) {
            case 1:
                return new Executor1();
            case 2:
                return new Executor2();
            case 3:
                return new Executor3();
            default:
                return new Executor1();
        }
    }

    @Bean
    @Qualifier("auto2")
    public IExecutor executorBean2() {
        String propertyLoc = this.env.getProperty("executor.type");
        int type = Integer.parseInt(propertyLoc);
        switch (type) {
            case 1:
                return new Executor1();
            case 2:
                return new Executor2();
            case 3:
                return new Executor3();
            default:
                return new Executor1();
        }
    }

}
