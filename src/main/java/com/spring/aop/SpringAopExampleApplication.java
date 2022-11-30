package com.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopExampleApplication.class, args);
    }

}
