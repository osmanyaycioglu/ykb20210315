package com.training.micro.order.models;

public class NotificationRequest {

    private String destination;
    private String message;

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(final String destinationParam) {
        this.destination = destinationParam;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    @Override
    public String toString() {
        return "NotificationRequest [destination=" + this.destination + ", message=" + this.message + "]";
    }


}
