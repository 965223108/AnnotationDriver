package com.test.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.test.beans.Green;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean hasRed = registry.containsBeanDefinition("com.test.beans.Red");
		boolean hasYello = registry.containsBeanDefinition("com.test.beans.Yellow");
		if(hasRed && hasYello)
		{
			BeanDefinition beanDefinition=new RootBeanDefinition(Green.class);
			registry.registerBeanDefinition("green", beanDefinition);
		}
		
	}

}
