package com.alpha.one.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Webxml_appInitializer // implements WebApplicationInitializer
{

	public void onStartup(ServletContext servletContext) throws ServletException {

		/*
		 * // THIS CLASS INSTEAD OF WEB.XML FILE-- 1st approach appInitailizer
		 * 
		 * //1 create application context for xml dispatcher servlet xml file in webinf
		 * 
		 * XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		 * appContext.setConfigLocation("/WEB-INF/dispatcher-config.xml");
		 * 
		 * 
		 * //1 create application context for dispatcher class- spring configuration
		 * class AnnotationConfigWebApplicationContext dispatcherContext = new
		 * AnnotationConfigWebApplicationContext();
		 * dispatcherContext.register(Servletxml_appConfig.class);
		 * 
		 * 
		 * //2 create new dispatcher servlet //3 register the DS
		 * ServletRegistration.Dynamic dispatcher =
		 * servletContext.addServlet("mydispatcher", new
		 * DispatcherServlet(dispatcherContext));
		 * 
		 * dispatcher.setLoadOnStartup(1); dispatcher.addMapping("/mywebsite.com/*");
		 */
	}

}
