package com.test.transaction;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 导包：spring-jdbc
 * 配置数据源和jdbctemplate(spring提供的简化数据库操作工具)
 * 事务：
 * 添加注解  @EnableTransactionManagement @Transactional
 *添加事务管理器组件到容器中 transactionManager
 */
@EnableTransactionManagement  //需要自己配置事务管理器
@PropertySource(value = "classpath:/com/test/transaction/db.properties")
@ComponentScan(basePackages = {"com.test.work.*"})
@Configuration
public class TxConfig {
	@Value("${db.password}")
	private String dbPassword;
	@Value("${db.user}")
	private String dbUser;
	@Value("${db.driver}")
	private String dbDriver;
	@Value("${db.url}")
	private String dbUrl;
	
	@Bean
	public DataSource dataSource() throws Exception
	{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(dbUser);
		dataSource.setPassword(dbPassword);
		dataSource.setDriverClass(dbDriver);
		dataSource.setJdbcUrl(dbUrl);
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource)
	{
		return new DataSourceTransactionManager(dataSource);
	}
	

}
