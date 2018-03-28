package com.vt.demo.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		Map result = null;
		
		try {
			result = mapper.readValue(request.getReader(), Map.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  (String)result.get("password");
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		Map result = null;
		
		try {request.getAttributeNames();
			result = mapper.readValue(request.getReader(), Map.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (String)result.get("username");
	}

	@Override
	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		// TODO Auto-generated method stub
		super.setAuthenticationManager(authenticationManager);
	}



}
