package com.sprphnx.phonebook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sprphnx.phonebook.model.ContactDTO;

@SpringBootApplication
public class PhonebookApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PhonebookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ContactDTO dto = new ContactDTO.Builder().with(x->{
			x.name="Rohan";
			x.phoneNumber="+91998839984";
		}).build();
		
		System.out.println(dto.toString());
	}
	

}
