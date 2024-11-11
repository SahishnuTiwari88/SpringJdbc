package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;



@Configuration

//@ComponentScan(basePackages = "com.spring.jdbc")
public class JDBCConfig {
	
	@Bean(name = {"ds"})
	public DataSource getDataSource() {//DataSource
		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Sarvesh143");
		return ds;
		}
	
	@Bean(name = {"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
		
	}
	@Bean(name = {"studentDao"})
	
	public StudentDao getStudentDao() {
		StudentDaoImpl studentDao = new StudentDaoImpl();// here we remove bean part b/c we perform autowiring
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
	}

}

// in autowiring whose object to be created is mentioned as @Component(do not mention @Bean) and its information given in 
//config file as @ComponentScan and where we have to inject depedency marked as autowire like dependency of jdbcTemplate 
//in config file which is inject in jdbcTemplate property in StudentDaoImpl
