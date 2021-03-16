package com.training.micro.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.training.micro.rest.Person;

@Service
public class PersonService {

    private final Map<String, Person> personMap = new ConcurrentHashMap<>();
    private final AtomicLong          counter   = new AtomicLong();
    private long                      counter2;

    public void add(final Person peron) {
        this.personMap.put(peron.getUsername(),
                           peron);
    }

    public synchronized void increase() {
        this.counter2++;
    }

    public void increase2() {
        this.counter.incrementAndGet();
    }

}
