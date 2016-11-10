package com.users.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.users.beans.ContactImage;

public interface ContactImageRepository extends CrudRepository<ContactImage, Long> {

	List<ContactImage> findByContactId(long contactId);

	//adding contact images to a list by contact id
	
}
