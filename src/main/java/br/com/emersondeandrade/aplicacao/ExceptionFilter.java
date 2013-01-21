package br.com.emersondeandrade.aplicacao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class ExceptionFilter extends SimpleMappingExceptionResolver {
	

	
	@Override
	protected void logException(Exception ex, HttpServletRequest request) {
		// TODO Auto-generated method stub
		ex.printStackTrace();
		
		super.logException(ex, request);
	}
	
	

}
