package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InvoiceAspect {

    @Pointcut("execution(public void com.spring.aop.service.InvoiceBusinessService.saveInvoice())")
    public void pointcutForSave() {
    }

    @Pointcut("execution(public * com.spring.aop.service.InvoiceBusinessService.getInvoice())")
    public void pointcutForGet() {
    }

    @Pointcut("@annotation(com.spring.aop.annotation.TestAnnotation)")
    public void pointcutForTest() {
    }

    @Before("pointcutForSave()")
    public void beginTransaction() {
        System.out.println("Transaction begins!");
    }

    @After("pointcutForSave()")
    public void completeTransaction() {
        System.out.println("Transaction completes!");
    }

    @AfterThrowing("pointcutForSave()")
    public void rollbackTransaction() {
        System.out.println("Transaction rolled back!");
    }

    @AfterReturning(value = "pointcutForGet()", returning = "obj")
    public void getAdviceReturnValue(Object obj) {
        System.out.println("Returning value is: " + obj);
    }

    @AfterThrowing(value="pointcutForSave()", throwing = "th")
    public void rollbackTransactionGetMessage(Throwable th) {
        System.out.println("Transaction rolled back ! Message from method : "+th.getMessage());
    }

    @Around("pointcutForTest()")
    public void testAroundAdvice(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Around -> Executing before part of business method");
        point.proceed();
        System.out.println("Around -> Executing after part of business method");
    }
}
