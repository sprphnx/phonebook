package com.sprphnx.phonebook.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprphnx.phonebook.model.ContactDTO;
import com.sprphnx.phonebook.redis.entity.Contact;
import com.sprphnx.phonebook.redis.entity.Contact.Gender;
import com.sprphnx.phonebook.redis.repository.QuickContactsRepository;

@RestController
@RequestMapping("/phonebook/contacts")
public class ContactsApi {

	@Autowired
	QuickContactsRepository quickContactsRepository; 
	
	Logger log = LoggerFactory.getLogger(ContactsApi.class);
	
	@GetMapping("/")
	public List<ContactDTO> getContacts(){
		List<ContactDTO> response = new ArrayList<>();
		response.add(new ContactDTO.Builder().with(x -> {
															x.name = "Rohan";
															x.phoneNumber = "+9188838942";
														}).build());
		response.add(new ContactDTO.Builder().with(x -> {
															x.name = "Rohan";
															x.phoneNumber = "+9188838942";
														}).build());
		return response;
	}
	
	@PostMapping("/")
	public Contact addQuickContacts(@RequestBody ContactDTO contact) {
		return quickContactsRepository
				.save(new Contact("5", contact.getName(), "", Gender.MALE, contact.getPhoneNumber()));
	}
	
}
