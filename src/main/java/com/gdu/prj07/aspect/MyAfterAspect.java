package com.gdu.prj07.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAfterAspect {

    //PointCut
    @Pointcut("execution(* com.gdu.prj07.controller.*Controller.*(..))")
    public void setPointCut(){}

    /*
     *  After Advice Method 작성 방법
     * 1. 반환타임 : void
     * 2. 메소트명: 마음대로
     * 3. 매개변수 : JoinPoint 타입 객체
     *
     * */
    //Advice
    @After("setPointCut()")
    public void myAfterAdvice(JoinPoint joinPoint){
        log.info("{}\n",StringUtils.repeat("-", 80));
    }

}
