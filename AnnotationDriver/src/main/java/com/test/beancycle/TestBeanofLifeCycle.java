package com.test.beancycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.annotation.MyConfig;
import com.test.beans.Car;

/*
 * 测试bean的生命周期
 * 
 * 创建 ---初始化----销毁
 * 1.通过@Bean注解来指定
 * 
 * 注意：
 * 在单实例：
 *	   创建方法： 容器创建的时候回
 *	  销毁方法：容器关闭的时候
 *在多实例：
 *	 创建方法：在获取实例的时候
 *	销毁方法： 容器不会管理这个bean，容器不会调用销毁方法
 *
 *
 */
public class TestBeanofLifeCycle {
	
	public static void main(String[] args)
	{
		ApplicationContext iocApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		Car car = (Car) iocApplicationContext.getBean("car");
		System.out.println(car);
	}

}
