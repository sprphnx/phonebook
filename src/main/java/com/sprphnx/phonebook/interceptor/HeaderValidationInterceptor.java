package com.sprphnx.phonebook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprphnx.phonebook.interceptor.exception.model.InvalidTokenDTO;


@Component
public class HeaderValidationInterceptor implements HandlerInterceptor {

	Logger log = LoggerFactory.getLogger(HeaderValidationInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("WE ARE INSIDE THE INTERCEPTOR");
		
		String token = request.getHeader("VALIDATION_TOKEN");
		
		if(!"PASS".equals(token)) {
			ObjectMapper mapper = new ObjectMapper();
			String value = mapper.writeValueAsString(new InvalidTokenDTO("101", "Error in token"));
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.setContentType("application/json");
			response.getWriter().write(value);
			response.getWriter().flush();
			response.getWriter().close();
			return false;
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
