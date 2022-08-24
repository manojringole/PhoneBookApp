package com.BikkadIT.phoneBookApp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	@Override
	public List<Contact> getAllContact() {
		
		List<Contact> findAll = contactRepository.findAll();
		
		List<Contact> collect = findAll.stream().filter(contact -> contact.getActiveSwitch()=='Y')
		                      .collect(Collectors.toList());
		
		return collect;
	}

	@Override
	public Contact getContactById(Integer cid) {
		
		Contact findById = contactRepository.findById(cid).get();
		return findById;
	}

	@Override
	public boolean updateContact(Contact contact) {
		
		Contact save = contactRepository.save(contact);
		if(save == null) {
			return false;
		}else {
		return true;
	}}

	@Override
	public boolean deleteById(Integer cid) {
		
		//hard deleted
		
/*		boolean existsById = contactRepository.existsById(cid);
		
		if(existsById) {
			
			contactRepository.deleteById(cid);
			return true;
		}
		else {
		return false;
	}*/
	         //2nd way delete
		
	//	 Optional<Contact> findById = contactRepository.findById(cid);
//			
//			if(findById.isPresent()) {
//				contactRepository.deleteById(cid);
//				return true;
//				}else {
//					return false;
//				}
		
		//soft delete
		
				Optional<Contact> contact = contactRepository.findById(cid);
				if(contact.isPresent()) {
					
					Contact contact2 = contact.get();
					contact2.setActiveSwitch('N');
					contactRepository.save(contact2);
					return true;
				}else {
					
					return false;
				}
		
		
	}

}
