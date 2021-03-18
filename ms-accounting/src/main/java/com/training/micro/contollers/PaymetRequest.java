package com.training.micro.contollers;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PaymetRequest {

    @Size(min = 2, max = 20)
    private String     customer;
    @NotNull
    @Positive
    private Long       customerId;
    @DecimalMax("1000")
    @DecimalMin("10")
    @Positive
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
