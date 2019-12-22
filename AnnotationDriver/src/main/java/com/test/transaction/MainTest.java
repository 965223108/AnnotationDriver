package com.test.transaction;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.test.beans.Person;
import com.test.work.service.UserService;



public class MainTest {
	
	@Test
	public void test1() throws Exception
	{
		ApplicationContext txApplicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
		DataSource dataSource = txApplicationContext.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}
	@Test
	public void test2() throws Exception
	{
		ApplicationContext txApplicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
		UserService userService = txApplicationContext.getBean(UserService.class);
		Person person=new Person("小花", 12, "0", "152333");
		int count = 1;
		long start_time = System.currentTimeMillis();
		while(count < 10000)
		{
			boolean result = userService.insert(person);
			System.out.println(String.valueOf(count) + "===> " + result);
			count = count + 1;
		}
		System.out.println("总共花费时间：" + (System.currentTimeMillis() - start_time)/1000);
		
		
	}

}
