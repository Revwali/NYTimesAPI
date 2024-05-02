package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class CustomAuthentication extends BasicAuthenticationEntryPoint {
	
	@Override
	public void commence(HttpServletRequest req,HttpServletResponse res, AuthenticationException Exp) throws IOException{
		
		res.addHeader("test", "test "+getRealmName());
		res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter pw= res.getWriter();
		pw.println("HTTP Staus 401 - "+Exp.getMessage());
		
	}
	
	@Override
	public void afterPropertiesSet(){
		setRealmName("test");
		super.afterPropertiesSet();
	}

}
