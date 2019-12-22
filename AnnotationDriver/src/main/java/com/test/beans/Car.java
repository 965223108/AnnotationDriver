package com.test.beans;

public class Car {
	
	public Car()
	{
		System.out.println("car对象创建");
	}
	
	public void init()
	{
		System.out.println("car对象初始化");
	}
	
	public void destroy()
	{
		System.out.println("car对象销毁");
	}

}
