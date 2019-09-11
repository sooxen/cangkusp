package com.lin.cangkusp.common.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.time.LocalDateTime;

@Aspect
@Component
public class puy {

    @Autowired
    private ObjectMapper objectMapper;

    @Pointcut(value = "@annotation(com.lin.cangkusp.common.config.yu)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Parameter[] parameters = method.getParameters();
        StringBuilder builder = new StringBuilder();
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();


        builder.append(className+"."+methodName);
        for (Object arg : joinPoint.getArgs()) {
            String s = null;
            try {
                s = objectMapper.writeValueAsString(arg);
            } catch (Exception e) {
                s = arg.getClass().getName();

            }
            builder.append(s);
        }
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long perid = end - start;
        builder.append(":" + objectMapper.writeValueAsString(proceed));
        System.out.println(builder.toString()+":"+perid);
        return proceed;
    }
}
