package com.test.annotation;

import java.io.IOException;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class ScanFilter implements TypeFilter{

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		String nameString = metadataReader.getAnnotationMetadata().getClassName();
		System.out.println("====>" + nameString);
		if(nameString.contains("HelloService"))
		{
			return true;
		}
		return true;
	}

}
