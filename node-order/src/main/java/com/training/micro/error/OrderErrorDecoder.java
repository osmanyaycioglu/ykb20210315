package com.training.micro.error;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class OrderErrorDecoder implements ErrorDecoder {

    @Override
    public MyRestClientException decode(final String methodKeyParam,
                                        final Response responseParam) {
        if (responseParam.status() != 404) {
            try {
                InputStream asInputStreamLoc = responseParam.body()
                                                            .asInputStream();
                ObjectMapper mapperLoc = new ObjectMapper();
                ErrorObject readValueLoc = mapperLoc.readValue(asInputStreamLoc,
                                                               ErrorObject.class);
                return new MyRestClientException(readValueLoc);
            } catch (Exception eLoc) {
                return new MyRestClientException(eLoc.getMessage());
            }
        }
        return new MyRestClientException("Not found exception");
    }

}
