/**   
 * @Title: HandlerLogAspect.java 
 * @Package com.example.aop 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月16日 下午3:59:24 
 * @version 
 */
package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: HandlerLogAspect 
 * @Description: 自定义注解类
 * @author 
 * @date 2018年3月16日 下午3:59:24 
 *  
 */
@Component
@Aspect
public class HandlerLogAspect {

	@Pointcut(value = "@annotation(com.example.aop.HandlerLog)")
	public void access() {

	}

	@Before("access()")
	public void deBefore(JoinPoint joinPoint) throws Throwable {
		System.out.println("second before");
	}

	@Around("@annotation(handlerLog)")
	public Object around(ProceedingJoinPoint pjp, HandlerLog handlerLog) {
		// 获取注解里的值
		System.out.println("second around:" + handlerLog.desc());
		try {
			return pjp.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			return null;
		}
	}
}
