package com.sprphnx.phonebook.interceptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sprphnx.phonebook.interceptor.HeaderValidationInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	HeaderValidationInterceptor HeaderValidationInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(HeaderValidationInterceptor);
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	
	
}
