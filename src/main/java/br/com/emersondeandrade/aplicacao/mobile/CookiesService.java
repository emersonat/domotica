package br.com.emersondeandrade.aplicacao.mobile;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Service;

@Service
public class CookiesService {
	
		
		
	public  String getValue(String cookieName, Cookie[] cookies){
		if(cookies == null)
			return "";
		
		for(Cookie cookie : cookies){
			if (cookie.getName().equals(cookieName) ){
				return cookie.getValue(); 
			}
		}
		
		return "";
	}	
		
	

}
