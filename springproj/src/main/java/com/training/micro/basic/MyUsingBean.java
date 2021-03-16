package com.training.micro.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyUsingBean {

    @Autowired
    private MyBean       mBean;

    private final MyBean myBean;

    private MyBean       myBean2;


    public MyUsingBean(final MyBean myBeanParam) {
        this.myBean = myBeanParam;
    }

    @Autowired
    public void methodWire(final MyBean myBeanParam) {
        this.myBean2 = myBeanParam;
    }


    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }

    public void exec() {
        this.mBean.hello();
        this.myBean.hello();
    }

}
