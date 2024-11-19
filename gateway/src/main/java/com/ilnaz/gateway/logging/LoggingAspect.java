package com.ilnaz.gateway.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;


@Component
@Aspect
public class LoggingAspect {

    private static String DIV = "================================= \n";
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(com.ilnaz.gateway.logging.Logging)")
    public void allSellerServiceMethods() {
    }

    @Before("allSellerServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info(DIV + "Вызов метода: " + methodName + " с аргументами: " + args);
    }


    @After("allSellerServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info(DIV + "Метод " + methodName + " завершил выполнение");
    }

    @AfterReturning(pointcut = "allSellerServiceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        var resultString = Optional.ofNullable(result)
                .map(Object::toString)
                .orElse(DIV + "Метод " + methodName + " void, ничего не возвращает");
        log.info(DIV + "Метод " + methodName + "вернул значение : " + resultString);

    }
}
