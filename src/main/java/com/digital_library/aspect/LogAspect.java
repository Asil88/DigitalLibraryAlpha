
package com.digital_library.aspect;

import com.digital_library.domain.Article;
import com.digital_library.service.ArticleService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
public class LogAspect {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.digital_library.service.ArticleService.getArticleById())")
    public void logBeforeAdvice(JoinPoint joinPoint) {
        log.info("LOG:DOBAVLEN ARTICL,KRUTO!");
        System.out.println(joinPoint.getSignature());
        Article article = (Article) joinPoint.getTarget();
        System.out.println("ARTICLE: " + article.getTitle() + " BIL SOZDAN " + article.getDateOfCreation() + " BYDYSHAYA SILKA NA SKA4IVANIE " + article.getDownload());
        //return article;
    }

    /*@After("execution(public * t*(..))")
    public void logAfterAdvice(JoinPoint joinPoint) {
        log.info("THIS LOG AFTER MESSAGE");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Сигнатура метода" + methodSignature);
    }*/


    @Around("@annotation(com.digital_library.annotations.CheckTimeAnnotation)")
    public Object logAfterAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalTime start = LocalTime.now();
        System.out.println("Timer start...");
        Object proceed = joinPoint.proceed();
        LocalTime end = LocalTime.now();
        System.out.println("Timer end...");
        log.info(String.valueOf(end.getNano() - start.getNano()));
        return proceed;

      /*  long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;*/
    }

  /*  @AfterReturning("within(com.digital_library.service.ArticleService)")
    public void logAfterReturning(JoinPoint joinPoint) {
        log.info("THIS LOG AFTER  returning MESSAGE");
        System.out.println(joinPoint.getSignature());
    }

    @AfterThrowing(value = "within(com.digital_library.service.ArticleService)", throwing = "e")
    public void logAfterThrowing(RuntimeException e) {
        log.info("THIS LOG AFTER Throwing MESSAGE");
    }*/
}

