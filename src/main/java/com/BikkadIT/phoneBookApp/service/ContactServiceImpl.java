package com.BikkadIT.phoneBookApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.phoneBookApp.entity.Contact;
import com.BikkadIT.phoneBookApp.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactServiceI {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
		
		Contact save = contactRepository.save(contact);
		
		if(save != null) {
			
			return true;
		}
		return false;
	}

}
