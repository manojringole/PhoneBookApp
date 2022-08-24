package com.BikkadIT.phoneBookApp.service;

import java.util.List;

import com.BikkadIT.phoneBookApp.entity.Contact;

public interface ContactServiceI {

	boolean saveContact(Contact contact);
	
	List<Contact> getAllContact();
	
	Contact getContactById(Integer cid);
	
	public boolean updateContact(Contact contact);
	
	boolean deleteById(Integer cid);
}
