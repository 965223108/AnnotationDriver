package com.test.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*
 * AOP在spring中的使用方式：
 * 					1. 将业务组件和切面类 都加到容器中，且在切面类中使用@aspect指定此类为切面
 * 					2. 在切面类中的每个方法中添加切入的方式（注意切入点 表达式）
 * 					3. 在配置类中开启AOP功能@EnableAspectJAutoProxy
 */
public class MainTest {
	
	@Test
	public void test1()
	{
		ApplicationContext aopApplicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
		Calculate calculate = aopApplicationContext.getBean(Calculate.class);
		calculate.add(1, 2);
		calculate.dev(1, 0);
	}

}
