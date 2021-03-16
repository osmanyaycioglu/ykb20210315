package com.training.micro.basic.intf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "executor")
public class ExecutorProp {

    private Integer type;
    private String  name;
    private String  desc;

    public Integer getType() {
        return this.type;
    }

    public void setType(final Integer typeParam) {
        this.type = typeParam;
    }


    public String getName() {
        return this.name;
    }


    public void setName(final String nameParam) {
        this.name = nameParam;
    }


    public String getDesc() {
        return this.desc;
    }


    public void setDesc(final String descParam) {
        this.desc = descParam;
    }


}
