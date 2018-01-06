package com.ebupt.vnbo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xujun on 2017/10/18.
 */
@Aspect
@Component
public class WebLoggerAop {
    private static final Logger logger= LoggerFactory.getLogger(WebLoggerAop.class.getName());
    @Pointcut("execution(public * com.ebupt.vnbo.web..*.*(..))")
    private void attachLog(){}
    @Before(value = "attachLog()")
    
    public void methordBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("------------------接收到请求----------------");
        logger.info("请求地址= "+request.getRequestURL());
    }
    @AfterReturning(returning = "re",pointcut = "attachLog()")
    public void methordAfterReturning(Object re){
        logger.info("---------------返回结果-------------------");
        logger.info("response: "+re.toString());

    }
  /*  @Pointcut("execution(public * errorHandler(..))")
    private void bugLog(){}
    @Before(value="bugLog()")
    public void beforeBug(JoinPoint joinPoint){
    	logger.error("--------------发现bug----------------");
    	logger.error("error=  "+joinPoint.toString());
    }
    */
}
