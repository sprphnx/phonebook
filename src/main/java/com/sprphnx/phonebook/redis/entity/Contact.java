package com.sprphnx.phonebook.redis.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash(value="Contact",timeToLive=10)
public class Contact {

	@Id
	private String contactId;
    private String fname;
    private String lname;
    private Gender gender;
    private String phoneNumber;
    
    public Contact(String contactId, String fname, String lname, Gender gender, String phoneNumber) {
		super();
		this.contactId = contactId;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}

	public enum Gender { 
        MALE, FEMALE
    }

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + "]";
	}
}

