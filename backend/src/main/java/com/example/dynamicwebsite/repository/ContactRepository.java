package com.example.dynamicwebsite.repository;

import com.example.dynamicwebsite.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
