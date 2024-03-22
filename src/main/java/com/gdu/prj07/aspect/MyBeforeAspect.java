package com.gdu.prj07.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class MyBeforeAspect {

    //PointCut
    @Pointcut("execution (* com.gdu.prj07.controller.*Controller.*(..))")
    public void setPointCut() {
    }


    /*
     *  Before Advice Method 작성 방법
     * 1. 반환타임 : void
     * 2. 메소트명: 마음대로
     * 3. 매개변수 : JoinPoint 타입 객체
     *
     * */
    //Advice
    @Before("setPointCut()")
    public void myBeforeAdvice(JoinPoint joinPoint) {

        // 요청 메소드/주소/파라미터 로그 남기기

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        //parameters are string array
        Map<String, String[]> params = request.getParameterMap();

        String str = "";

        if(params.isEmpty()){
            str += "No Parameter";
        }else{
            for(Map.Entry<String, String[]> entry : params.entrySet()){
                str += entry.getKey() + ":" + Arrays.toString(entry.getValue()) + " ";
            }
        }

        log.info("{} | {}",request.getMethod(),request.getRequestURI());
        log.info("{}",str);

    }
}
