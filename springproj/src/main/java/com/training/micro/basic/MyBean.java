package com.training.micro.basic;

import org.springframework.stereotype.Component;


//@Controller -- HTTP
//@Repository -- DB Trans
//@Service -- Business Layer
//@Configuration -- Bean  Config

@Component
// @Scope("prototype")
public class MyBean {

    private String name;

    public void hello() {
        System.out.println("hello - " + this.name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

}
