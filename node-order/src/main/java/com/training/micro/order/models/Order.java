package com.training.micro.order.models;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Order {

    @NotEmpty
    private String       customer;
    @NotNull
    private Long         customerId;
    @NotNull
    @Size(min = 1)
    private List<String> meals;

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(final String customerParam) {
        this.customer = customerParam;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Long customerIdParam) {
        this.customerId = customerIdParam;
    }

    public List<String> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<String> mealsParam) {
        this.meals = mealsParam;
    }

    @Override
    public String toString() {
        return "Order [customer=" + this.customer + ", customerId=" + this.customerId + ", meals=" + this.meals + "]";
    }


}
