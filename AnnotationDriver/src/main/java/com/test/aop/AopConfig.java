package com.test.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AopConfig {
	
	@Bean
	public Calculate myCalculate()
	{
		return new Calculate();
	}
	
	@Bean
	public LogAop myLogAop()
	{
		return new LogAop();
	}

}
