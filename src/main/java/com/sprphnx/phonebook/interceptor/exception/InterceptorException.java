package com.sprphnx.phonebook.interceptor.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprphnx.phonebook.interceptor.exception.model.InvalidTokenDTO;

@RestController
@RequestMapping("/phonebook/exception")
public class InterceptorException {

	@GetMapping("/invalidtoken")
	public InvalidTokenDTO invalidToken() {
		return new InvalidTokenDTO("101", "INVALID TOKEN IN HEADER");
	}
	
}
