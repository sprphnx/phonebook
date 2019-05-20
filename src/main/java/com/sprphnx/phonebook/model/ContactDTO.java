package com.sprphnx.phonebook.model;

import java.util.function.Consumer;

import com.sprphnx.phonebook.redis.entity.Contact;

public class ContactDTO {

	private String name;
	private String phoneNumber;
	
	private ContactDTO() {
		super();
	}

	private ContactDTO(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static class Builder{
		public String name;
		public String phoneNumber;
		
		public Builder with(
	            Consumer<Builder> builderFunction) {
	        builderFunction.accept(this);
	        return this;
	    }
		
		public ContactDTO build() {
	        return new ContactDTO(name,
	        				  phoneNumber);
	    }
		
		public ContactDTO withContact(Contact contact) {
			return this.with(x->{
				x.name = contact.getFname();
				x.phoneNumber = contact.getPhoneNumber();
			}).build();
		}

	}
	
}
