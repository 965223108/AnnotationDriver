package com.test.annotation;

import org.springframework.beans.factory.FactoryBean;

import com.test.beans.Blue;
import com.test.beans.Color;

public class BlueColorFactory implements FactoryBean<Blue>{

	//返回的对象会被加到容器中
	public Blue getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Blue();
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Blue.class;
	}

	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
