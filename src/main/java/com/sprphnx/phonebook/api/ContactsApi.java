package com.sprphnx.phonebook.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprphnx.phonebook.model.ContactDTO;

@RestController
@RequestMapping("/phonebook/contacts")
public class ContactsApi {

	@GetMapping("/")
	public List<ContactDTO> getContacts(){
		List<ContactDTO> response = new ArrayList<>();
		response.add(new ContactDTO("Rohan", "+566554445787"));
		response.add(new ContactDTO("Ramya", "+998877887765"));
		return response;
	}
	
}
