package com.training.micro;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringprojApplication implements ApplicationRunner {

    public static void main(final String[] args) {
        SpringApplication.run(SpringprojApplication.class,
                              args);
    }

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        System.out.println("Hello world");
    }

    @Scheduled(fixedDelay = 10_000)
    public void name() {
        System.out.println("Hello world Scheduled");
    }

}
