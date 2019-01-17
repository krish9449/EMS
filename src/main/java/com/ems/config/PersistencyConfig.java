package com.ems.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.ems.entiites.Employee;

@Configuration
@ComponentScan(basePackages = { "com.ems.dao"})
@PropertySource("classpath:db.properties")
public class PersistencyConfig {
	@Autowired
	public Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = null;
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		
		return dataSource;
	}
	
	@Bean(autowire=Autowire.BY_TYPE)
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = null;
		Properties hibernateProperties = null;
		
		hibernateProperties = new Properties();
		hibernateProperties.put("show_sql", "true");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.put("format_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		
		localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setHibernateProperties(hibernateProperties);
		//localSessionFactoryBean.setAnnotatedPackages("com.ems.entities");
		//localSessionFactoryBean.setPackagesToScan("com.ems.entities");
		localSessionFactoryBean.setAnnotatedClasses(Employee.class);
		
		return localSessionFactoryBean;
	}
	
	@Bean(autowire=Autowire.BY_TYPE)
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate hibernateTemplate = null;

		hibernateTemplate = new HibernateTemplate();
		return hibernateTemplate;
	}
	
	@Bean(autowire=Autowire.BY_TYPE)
	public PlatformTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = null;
		transactionManager = new HibernateTransactionManager();
		
		return transactionManager;
	}
	
}

