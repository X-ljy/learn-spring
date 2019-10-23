package com.ljy.qx.learnaop.aspect;

import com.ljy.qx.learnaop.annotation.LogAnnoatation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author : 夕
 * @date : 2019/10/23
 */
@Aspect
@Component
public class LogAspect {

    //定义一个切面
    @Pointcut("@annotation(com.ljy.qx.learnaop.annotation.LogAnnoatation)")
    public void annotationPointCut(){
        System.out.println("annotationPointCut");
    }

    @Before("annotationPointCut()")
    public void doBefore(JoinPoint joinPoint){

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        LogAnnoatation annoatation = method.getAnnotation(LogAnnoatation.class);
        System.out.println(annoatation.value());

        System.out.println("doBefore  调用");

    }


    @After("annotationPointCut()")
    public void doAfter(){
        System.out.println("doAfter调用");
    }

    @Around("annotationPointCut()")
    public String doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("doAround调用");
        Object obj = proceedingJoinPoint.proceed();  //环绕通知必须调用此方法，并将返回值返回。否则切面的方法没有返回值。
        return (String) obj;
    }

    @AfterReturning(value = "annotationPointCut()",returning = "result")
    public void doAfterReturning(Object result){
        System.out.println("doAfterReturning调用: " + result);
    }

    @AfterThrowing(value = "annotationPointCut()",throwing = "e")
    public void doAfterThrowing(Throwable e){
        System.out.println("doAfterThrowing调用");
    }

}
