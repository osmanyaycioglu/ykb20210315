package com.training.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.training.micro.basic.MyBean;
import com.training.micro.basic.MyUsingBean;
import com.training.micro.basic.intf.IExecutor;

@SpringBootApplication
@EnableScheduling
public class SpringprojApplication implements ApplicationRunner {

    @Autowired
    private MyBean      mBean;

    @Autowired
    private MyBean      mBean2;

    @Autowired
    private MyUsingBean muse;

    @Autowired
    @Qualifier("auto")
    private IExecutor   exec;

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        System.out.println("Hello world");
        this.mBean.setName("osman");
        this.mBean.hello();
        this.mBean2.setName("nil");
        this.mBean2.hello();
        this.muse.exec();
        System.out.println(this.exec.exec("ayşe"));
    }

    @Scheduled(fixedDelay = 10_000)
    public void name() {
        System.out.println("Hello world Scheduled");
    }

}
