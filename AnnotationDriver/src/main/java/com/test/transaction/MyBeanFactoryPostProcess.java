package com.test.transaction;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/*
 * 容器工厂的后置处理器
 * 工厂已经读取了配置文件中的各种类信息但是还没有初始化对象的时候调用 跟bean的后置处理器有些类似
 */
public class MyBeanFactoryPostProcess implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

}
