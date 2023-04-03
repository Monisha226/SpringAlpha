package com.alpha.one.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class AlphaSecurity extends WebSecurityConfigurerAdapter {

	//from 5.7 version this super class is depricated
// create security filter chain(securityFilterchain) : who r u?...id-password ?...r u authorized?....validate session!
	
	// 1 .config password encoder bean in servlet-appconfig class
	
	//2. config username/ password / role
	
	@Autowired
	private PasswordEncoder passEncode;
	
	@Autowired
	private DataSource datasource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//1. hardcoding default user data
		auth.inMemoryAuthentication()
		.withUser("moni").password(passEncode.encode("moni")).roles("admin");
		//.password("moni")  -----cant store password  as plaintext....use password encoder
		
		/*
		 * //2.* load user from DB auth.jdbcAuthentication() .dataSource(datasource)
		 * .passwordEncoder(passEncode) ;
		 * 
		 * 
		 */
		
	}
	
	//3. authorize requests url...  authenticate req...with loginform/basicAuth
	@Override
	protected void configure(HttpSecurity http) throws Exception {


		
		http.authorizeRequests() //.anyRequest()    
		.antMatchers("/mywebsite.com/**").authenticated()   //authenticated()----shows login form
		.antMatchers("/","/home").permitAll()   //permitAll()-- no loginform
		//.antMatchers("/cafe").hasAuthority("user")
		.and()
		
		//formLogin()----shows up when request is from web browser
		//loginpage()----used for customised login page with its mapped url 
		//loginprocessingurl()----action for our customized login page
		
		.formLogin().loginPage("/login").loginProcessingUrl("mywebsite.com/cafe") 
		.usernameParameter("username").passwordParameter("password")
		.and().httpBasic() // shows up when request is from postman/java
		//.and().logout()
		//.and().exceptionHandling().accessDeniedPage("/AccessDenialPage")
		;   
	}
	
	
	
	
} 
