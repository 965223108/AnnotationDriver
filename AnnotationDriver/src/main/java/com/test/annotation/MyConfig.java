package com.test.annotation;


import static org.junit.Assert.fail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.test.beans.Blue;
import com.test.beans.Car;
import com.test.beans.Color;
import com.test.beans.Person;
import com.test.condition.LinuxCondition;
import com.test.condition.WindowCondition;
import com.test.work.service.HelloService;

@ComponentScans(value = {
//		@ComponentScan(basePackages = {"com.test.work"},includeFilters = {
//				@Filter(type=FilterType.ANNOTATION,classes = {Service.class})
//		}),
		@ComponentScan(basePackages = {"com.test.work"},includeFilters = {
				@Filter(type=FilterType.CUSTOM,classes = {ScanFilter.class})
		},useDefaultFilters = false)
})
//@ComponentScan(basePackages = {"com.test.work"},
//excludeFilters = {
//		@Filter(type = FilterType.ANNOTATION,value = {Controller.class}),
//		@Filter(type= FilterType.ASSIGNABLE_TYPE,value = {HelloService.class})
//		}
//)
@Configuration
@Import(value = {Color.class,com.test.beancycle.Car.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})  //ID 默认是全类名
public class MyConfig {
	
	@Scope("singleton")
	@Bean("person")
	@Lazy
	public Person getPerson()
	{
		System.out.println("创建person对象");
		return new Person("xioahua",11,"0","456789");
	}
	
	/*
	 * condition :按照条件来判断是否加入组件
	 * 如果放在方法上： 表示此方法是否生效
	 * 放在类上：表示此类是否生效
	 */
	@Bean()
	@Conditional(value = {WindowCondition.class})
	public Person personwind()
	{
		return new Person("windows",55,"1","789456");
	}
	
	@Bean
	@Conditional(value = {LinuxCondition.class})
	public Person personLinux()
	{
		return new Person("linux",56,"1","123456");
	}
	
	/*
	 * 给容器中添加组件：
	 * 1。包扫描+组件注解（@controller @Service @Repository @Component）
	 * 2。@Bean()   一次只能导入一个
	 * 3.@Import()  快速导入多个组件 
	 *    ImportSelector 接口
	 *    ImportBeanDefinitionRegistrar  接口
	 * 4. 使用spring的工厂bean:FactoryBean 需要把工厂bean加到容器中  在调用此对象的get方法实际上返回的才是实际类型
	 */
	@Bean
	public BlueColorFactory colorFactory()
	{
		return new BlueColorFactory();
	}
	
	
	/*
	 * bean对象的生命周期
	 * 1. 直接指定初始化和销毁方法
	 * 2.实现接口： InitializingBean DisposableBean
	 */
	@Bean(initMethod = "init",destroyMethod = "destroy")
	public Car car()
	{
		return new Car();
	}
	
	/*
	 * @profile 注解只要用于多环境支持
	 * 激活方式：
	 *		1. 在添加虚拟机启动参数： --DSpring.profile.active=dev
	 *		2.在创建容器的时候手动指定Environment的属性（调用容器的无参构造器，并设置容器的启动属性即可）				 		
	 */
	@Profile(value = "dev")
	public Blue blue()
	{
		return new Blue();
	}
	
	

}
