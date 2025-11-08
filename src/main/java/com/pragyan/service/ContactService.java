package com.pragyan.service;


import com.pragyan.Dto_Contact;
import com.pragyan.entity.Contact;
import com.pragyan.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
    public class ContactService{

        @Autowired
    ContactRepository contactRepository;

        public void save(Dto_Contact req) {
            Contact msg = new Contact();
            msg.setName(req.getName());
            msg.setEmail(req.getEmail());
            msg.setMessage(req.getMessage());
            msg.setPhone(req.getPhone());

            contactRepository.save(msg);
        }
    }


