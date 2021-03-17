package com.training.micro.contollers;

import java.math.BigDecimal;

public class PaymetRequest {

    private String     customer;
    private Long       customerId;
    private BigDecimal amount;

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

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(final BigDecimal amountParam) {
        this.amount = amountParam;
    }

    @Override
    public String toString() {
        return "PaymetRequest [customer="
               + this.customer
               + ", customerId="
               + this.customerId
               + ", amount="
               + this.amount
               + "]";
    }


}
