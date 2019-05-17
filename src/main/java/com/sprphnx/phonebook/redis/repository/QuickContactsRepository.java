package com.sprphnx.phonebook.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sprphnx.phonebook.redis.entity.Contact;

@Repository
public interface QuickContactsRepository extends CrudRepository<Contact, String> {

}
