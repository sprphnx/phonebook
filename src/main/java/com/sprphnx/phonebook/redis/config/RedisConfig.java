package com.sprphnx.phonebook.redis.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.sprphnx.phonebook.redis.repository.QuickContactsRepository;

@Configuration
@EnableRedisRepositories(enableKeyspaceEvents=RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP,basePackageClasses=QuickContactsRepository.class)
public class RedisConfig extends RedisKeyValueAdapter {

	@Autowired
	ApplicationEventPublisher applicationEventPublisher;
	
	Logger log = LoggerFactory.getLogger(RedisConfig.class);
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    return new JedisConnectionFactory();
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}
	
	/*@Bean
	public RedisMessageListenerContainer keyExpirationListenerContainer(JedisConnectionFactory connectionFactory) {

	    RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
	    listenerContainer.setConnectionFactory(connectionFactory);
	    listenerContainer.addMessageListener((message, pattern) -> {
	    	 RedisKeyExpiredEvent<Contact> redisKeyExpiredEvent = new RedisKeyExpiredEvent<>(message.getBody());
	    	 log.info("*************** TRY TO RETRIEVE BODY: {} *****************",redisKeyExpiredEvent.getValue());
	    	log.info("**************** REDIS KEY EXPIRED: {} *******************", new String(message.getBody()));
	    	try {
				Contact contact = (Contact) deserialize(message.getBody());
				log.info("REDIS EXPIRED: {}", contact.toString());
			} catch (ClassNotFoundException | IOException e) {
				log.error("Casting error on redis expired object: {}", e);
			}

	    }, new PatternTopic("__keyevent@*__:expired"));

	    return listenerContainer;
	}*/
	
	private Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is = new ObjectInputStream(in);
	    return is.readObject();
	}
	
}
