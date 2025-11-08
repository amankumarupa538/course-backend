package com.pragyan.controller;


import com.pragyan.Dto_Contact;
import com.pragyan.entity.Contact;
import com.pragyan.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/contact")
    @CrossOrigin("*")
    public class ContactController {

        @Autowired
        private ContactService contactService;

        @PostMapping("/save")
        public ResponseEntity<String> saveContact(@RequestBody Dto_Contact request) {
            contactService.save(request);
            return ResponseEntity.ok("Message saved successfully");
        }
    }


