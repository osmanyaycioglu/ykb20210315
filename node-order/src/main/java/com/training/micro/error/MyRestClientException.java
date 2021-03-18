package com.training.micro.error;


public class MyRestClientException extends Exception {

    private static final long serialVersionUID = -1320998252114390453L;

    private ErrorObject       errorObject;


    public MyRestClientException(final String str) {
        super(str);
    }

    public MyRestClientException() {
    }

    public MyRestClientException(final ErrorObject errorObjectParam) {
        super();
        this.setErrorObject(errorObjectParam);
    }

    public ErrorObject getErrorObject() {
        return this.errorObject;
    }

    public void setErrorObject(final ErrorObject errorObjectParam) {
        this.errorObject = errorObjectParam;
    }


}
