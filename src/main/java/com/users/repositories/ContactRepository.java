package com.users.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.users.beans.Contact;
import com.users.beans.User;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	Contact findByUserIdAndId(long userId, long id);
	

	List<Contact> findAllByUserIdOrderByFirstNameAscLastNameAsc(long userId);
	
	//the list is collecting users by the various variables
	List<User> findByLastNameOrFirstNameOrEmailOrTwitterHandleOrFacebookUrlIgnoreCase(
			String lastName, String firstName, String email, String twitterHandle,
			String facebookUrl);

	
	//The contact repo is collecting all of the users information and then sorting them in lists
	
}




