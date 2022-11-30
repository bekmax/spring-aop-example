package com.spring.aop.runner;

import com.spring.aop.service.InvoiceBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceRunner implements CommandLineRunner {

    public final InvoiceBusinessService service;

    @Override
    public void run(String... args) throws Exception {
        service.getInvoice();

        service.testForAroundAdvice();

        try {
            service.saveInvoice();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
