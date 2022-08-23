package com.BikkadIT.phoneBookApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.phoneBookApp.entity.Contact;
import com.BikkadIT.phoneBookApp.service.ContactServiceI;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping(value = "/saveContact" ,consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
		
		boolean saveContact = contactServiceI.saveContact(contact);
		
		if(saveContact == true) {
			
			String msg="Contact Saved Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			
			String msg="Contact Not saved Successfuly";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
	}
}
