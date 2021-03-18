package com.training.micro.error;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorObject {

    private List<ErrorObject> subErrors;
    private String            boundedContext;
    private String            microservice;
    private String            desc;
    private int               cause;


    public ErrorObject() {
    }

    public ErrorObject(final String boundedContextParam,
                       final String microserviceParam,
                       final String descParam,
                       final int causeParam) {
        super();
        this.boundedContext = boundedContextParam;
        this.microservice = microserviceParam;
        this.desc = descParam;
        this.cause = causeParam;
    }

    public ErrorObject(final String boundedContextParam,
                       final String microserviceParam,
                       final String descParam) {
        super();
        this.boundedContext = boundedContextParam;
        this.microservice = microserviceParam;
        this.desc = descParam;
    }

    public ErrorObject addSubErrors(final ErrorObject eo) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(eo);
        return this;
    }

    public List<ErrorObject> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObject setSubErrors(final List<ErrorObject> subErrorsParam) {
        this.subErrors = subErrorsParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public ErrorObject setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public ErrorObject setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public String getDesc() {
        return this.desc;
    }

    public ErrorObject setDesc(final String descParam) {
        this.desc = descParam;
        return this;
    }

    public int getCause() {
        return this.cause;
    }

    public ErrorObject setCause(final int causeParam) {
        this.cause = causeParam;
        return this;
    }


    private static final Logger logger = LoggerFactory.getLogger(ErrorObject.class);

    public static void main(final String[] args) {
        ErrorObject errorObjectLoc = new ErrorObject("bounded1",
                                                     "ms1",
                                                     "error oldu",
                                                     100);
        ErrorObject eObjectLoc = new ErrorObject().setBoundedContext("bounded1")
                                                  .setMicroservice("ms1")
                                                  .setDesc("error olşdu")
                                                  .setCause(100);

        ErrorObject.logger.debug("deneme" + args + " oldu");

        ErrorObject.logger.debug("deneme %s oldu",
                                 args[0]);

        if (ErrorObject.logger.isDebugEnabled()) {
            ErrorObject.logger.debug("[ErrorObject][main]-> deneme" + args + " oldu");
        }


    }

}
