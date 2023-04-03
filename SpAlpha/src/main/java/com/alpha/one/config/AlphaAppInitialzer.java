package com.alpha.one.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AlphaAppInitialzer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// THIS CLASS INSTEAD OF WEB.XML FILE -- 2nd approach appInitailizer
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class[] arr = {Servletxml_appConfig.class} ;
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		
		String[] arr = {"/","/mywebsite.com/*"} ;
		return arr;
	}

}
