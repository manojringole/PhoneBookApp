package com.BikkadIT.phoneBookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.phoneBookApp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
