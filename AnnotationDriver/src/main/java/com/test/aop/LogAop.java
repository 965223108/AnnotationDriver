package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
	@Pointcut("execution(public int com.test.aop.Calculate.*(..))")
	public void pointCut() {}
	
	@Before("execution(public int com.test.aop.Calculate.add(int,int))")
	public void logStart(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.print(methodName);
		System.out.println("log start");
	}
	
	@After("execution(public int com.test.aop.Calculate.*(..))")
	public void logEnd()
	{
		System.out.println("log logEnd");
	}
	
	@AfterReturning(value = "pointCut()",returning = "result")
	public void logReturn(Object result)
	{
		System.out.println("log logReturn");
	}
	
	@AfterThrowing(value = "pointCut()",throwing = "exception")
	public void logThrowing(Exception exception)
	{
		System.out.println("log Throwing");
	}
	
	
	
	

}
