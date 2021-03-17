package com.training.micro;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

// @Component
public class RestTemplateProxyX extends RestTemplate {

    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient ec;


    @Override
    public <T> T postForObject(final URI url,
                               @Nullable final Object request,
                               final Class<T> responseType) throws RestClientException {
        url.getPath();
        String hostLoc = url.getHost();


        return this.restTemplate.postForObject(null,
                                               request,
                                               responseType);
    }
}
