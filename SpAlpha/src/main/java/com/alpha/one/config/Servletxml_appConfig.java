package com.alpha.one.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages =  "com.alpha.one")
@PropertySource("classpath:alpha.properties")  //to tell server to fetch data from properties file
public class Servletxml_appConfig {

	//THIS CLASS INSTEAD OF SERVLET.XML FILE FOR SPRING CONFIGURATIONS
	@Autowired
	private Environment env;  //read data from properties file
	
		// set up view resolver bean
	@Bean
	InternalResourceViewResolver getViewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource());
		
		return jdbcTemplate;
	}
	
	@Bean
	  public DataSource dataSource() {
		
		DriverManagerDataSource  datasource= new DriverManagerDataSource();
		
		datasource.setUsername("root");
		datasource.setPassword("mysqlroot");
		datasource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
		//datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return datasource;
	}
	
	@Bean
	PasswordEncoder getpasswordencoder() {
		
		return new BCryptPasswordEncoder();
	}
	//set up mailSender configurations
	@Bean
	public JavaMailSender getMailSender() {
		
	
		JavaMailSenderImpl jmsi= new JavaMailSenderImpl();
		jmsi.setHost(env.getProperty("mail.host"));
		jmsi.setUsername(env.getProperty("mail.username"));
		jmsi.setPassword(env.getProperty("mail.password"));
		jmsi.setPort(Integer.parseInt(env.getProperty("mail.port")));
		
		Properties mailprop= new Properties();
		mailprop.put("mail.smtp.starttls.enable", true);
		mailprop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		jmsi.setJavaMailProperties(mailprop);
		return jmsi;
	}
}
