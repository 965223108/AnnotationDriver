package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.annotation.MyConfig;
import com.test.beans.Person;

public class TestMain {
	
	@Test
	public void AnnotaionTest()
	{
		AnnotationConfigApplicationContext iocAnnotation = new AnnotationConfigApplicationContext(MyConfig.class);
		String[] definationName = iocAnnotation.getBeanDefinitionNames();
		for (String name : definationName) {
			System.out.println(name);
		}
		Person person1 = (Person) iocAnnotation.getBean("person");
		Person person2 = (Person) iocAnnotation.getBean("person");
		System.out.println(person1==person2);
		Object object = iocAnnotation.getBean("colorFactory");
		//如果要获取工厂bean本身 可以在bean名字前面加上一个&符
		System.out.println("====>" +  object.getClass());
	}
	
	@Test
	public void xmlTest()
	{
		ApplicationContext iocxml =new ClassPathXmlApplicationContext("SpringApplication.xml");
		Person person = (Person)iocxml.getBean("person1");
		String[] nameStrings = iocxml.getBeanDefinitionNames();
		for (String nane : nameStrings) {
			System.out.println(nane);
		}
		System.out.println(person);
	}

}
