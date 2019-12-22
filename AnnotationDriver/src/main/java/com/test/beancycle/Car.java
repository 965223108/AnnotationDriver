package com.test.beancycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements InitializingBean,DisposableBean{
	
	public Car()
	{
		System.out.println("实现接口的对象创建");
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("实现接口的销毁方法 调用");
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("实现初始化接口的方法调用");
	}

}
