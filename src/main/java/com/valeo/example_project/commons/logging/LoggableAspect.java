package com.valeo.example_project.commons.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * Loggable aspect that logs the entrance and exits , execution time and the status of the methods.
 *
 * @author Hossam Khalil
 */
@Slf4j
@Aspect
@Component
public class LoggableAspect {

    @Around("(execution(* com.valeo..*(..)) && @annotation(Loggable))")
    public Object aroundTraceableMethod(ProceedingJoinPoint pjp) throws Throwable {

        if (log.isTraceEnabled()) {
            return executeWithTrace(pjp);
        }

        return pjp.proceed();
    }

    private Object executeWithTrace(ProceedingJoinPoint pjp) throws Throwable {

        String methodName = pjp.getSignature().toShortString();
        long start = System.currentTimeMillis();
        String status = "success";

        try {
            log.trace(LogMessages.methodEntry(methodName));
            return pjp.proceed();
        } catch (Throwable throwable) {
            status = "error";
            log.error(LogMessages.methodError(methodName, throwable.getMessage()));
            throw throwable;
        } finally {
            if (log.isTraceEnabled()) {
                String execTime = String.valueOf(System.currentTimeMillis() - start);
                log.trace(LogMessages.methodExit(methodName, status, execTime));
            }
        }
    }
}
