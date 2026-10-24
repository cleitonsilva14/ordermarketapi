package io.dev.ordermarketapi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Aspect 
@Component 
public class LoggingAspect {

    @Pointcut("execution(* io.dev.ordermarketapi.service.*.*(..))")
    public void serviceMethods(){

    }

    @Before("serviceMethods()")
    public void logServiceBefore(JoinPoint joinPoint){
        log.info("Entrando em: {}", joinPoint.getSignature().toLongString());
    }

    
}
