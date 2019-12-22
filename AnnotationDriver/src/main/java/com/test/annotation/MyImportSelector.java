package com.test.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/*
 * 返回值就是要导入容器中的组件全类名
 * importingClassMetadata ： 表示标注了@importSelector类的所有注解信息
 * 返回可以是空数组 但是不能是null
 */
public class MyImportSelector implements ImportSelector{

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		return new String[] {"com.test.beans.Red","com.test.beans.Yellow"};
	}

}
