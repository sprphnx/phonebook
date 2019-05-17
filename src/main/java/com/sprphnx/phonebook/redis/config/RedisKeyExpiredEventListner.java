package com.sprphnx.phonebook.redis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisKeyExpiredEvent;
import org.springframework.stereotype.Component;

import com.sprphnx.phonebook.redis.entity.Contact;

@Component
public class RedisKeyExpiredEventListner implements ApplicationListener<RedisKeyExpiredEvent<Object>> {
	
	Logger log = LoggerFactory.getLogger(RedisKeyExpiredEventListner.class);
	
	@Override
	public void onApplicationEvent(RedisKeyExpiredEvent<Object> event) {
		
		log.info("SUCESSSSSSSSSSSSSSSSSSSSSS {}",event.getValue());
		
		Contact contact = (Contact) event.getValue();
		
		log.info(contact.toString());
		
	}
}