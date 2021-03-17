package com.training.micro.order.models;

import java.util.List;

public class Order {

    private String       customer;
    private Long         customerId;
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
