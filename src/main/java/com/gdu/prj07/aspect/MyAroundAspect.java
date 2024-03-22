package com.gdu.prj07.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class MyAroundAspect {

    //PointCut : 언제 동작하는가?
    @Pointcut("execution(* com.gdu.prj07.controller.*Controller.*(..))")
    public void setPointCut() {
    }//할일을 여기 적는게 아님

    //Advice : 무슨 동작을 하는가?
    @Around("setPointCut()") //Around 가 setPointCut을 연결해줌
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //@TODO Check this StringUtil repeat
        log.info("{}", StringUtils.repeat("-", 80));                               //동작 이전

        Object obj = proceedingJoinPoint.proceed();                                           // 동작 시점

        log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date())); //동작 이후 (@After 이전)


        return obj;
    }

    /*
     * Around Advice 메소드 작성 방법
     * 1. 반환타임 : Object
     * 2. 메소드명 : 마음대로
     * 3. 매개변수 : ProceedingJoinPoint 타입 객체
     * */
}
