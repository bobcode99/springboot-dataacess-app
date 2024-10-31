package com.example.dbservice.routing;

import com.example.dbservice.config.TransactionContextHolder;
import com.example.dbservice.vo.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // Ensure this aspect runs before transaction aspects
@Slf4j
public class DataSourceRoutingAspect {

    @Around("execution(* com.example.dbservice.service.DataAccessService.*(..))")
    public Object determineDataSource(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            String methodName = joinPoint.getSignature().getName().toLowerCase();
            boolean isReadOnly = isReadOnlyOperation(methodName);

            TransactionContextHolder.setDataSourceType(
                    isReadOnly ? DataSourceType.READ : DataSourceType.WRITE
            );

            log.info("isReadOnly: {}", isReadOnly);

            return joinPoint.proceed();
        } finally {
            TransactionContextHolder.clear();
        }
    }

    private boolean isReadOnlyOperation(String methodName) {
        return methodName.startsWith("get") ||
                methodName.startsWith("find") ||
                methodName.startsWith("select") ||
                methodName.startsWith("query") ||
                methodName.startsWith("count") ||
                methodName.startsWith("list") ||
                methodName.startsWith("search");
    }
}