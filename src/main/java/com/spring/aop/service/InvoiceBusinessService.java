package com.spring.aop.service;

import com.spring.aop.annotation.TestAnnotation;
import org.springframework.stereotype.Service;

@Service
public class InvoiceBusinessService {

    public void saveInvoice() {
        System.out.println("Invoice is saved");
        throw new RuntimeException("This is a Runtime Exception");
    }

    public String getInvoice() {
        return "Invoice from getInvoice()";
    }

    @TestAnnotation
    public void testForAroundAdvice() {
        System.out.println("Business method is getting executed!");
    }
}
