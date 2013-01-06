package br.com.emersondeandrade.aplicacao;

import javax.servlet.ServletContextEvent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;


@Scope("singleton")
@Component
public class SpringUtils implements ApplicationContextAware{

	
   private static ApplicationContext context;

   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      initializeApplicationContext(applicationContext);
   }

	private static void initializeApplicationContext(ApplicationContext applicationContext) {
	    context = applicationContext;
    }
	
	public static ApplicationContext getApplicationContext() {
	    return context;
	}
	
	public static <T> T getBean(Class<T> Bean) throws BeansException {
	  return (T) context.getBean(Bean);
	}
	
	public static void autowiredThisBean(Object bean, ServletContextEvent serveletContextEvent){
		
		WebApplicationContextUtils
        	.getRequiredWebApplicationContext(serveletContextEvent.getServletContext())
        	.getAutowireCapableBeanFactory()
        	.autowireBean(bean);
		
	}
	
	   

}
