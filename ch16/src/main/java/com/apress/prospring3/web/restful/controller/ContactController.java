package com.apress.prospring3.web.restful.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apress.prospring3.domain.Contact;
import com.apress.prospring3.domain.Contacts;
import com.apress.prospring3.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	final Logger logger = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/listdata", method = RequestMethod.GET)
	@ResponseBody
	public Contacts listData() {

		return new Contacts(contactService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Contact findContactById(@PathVariable Long id) {

		return contactService.findById(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Contact create(@RequestBody @Valid Contact contact) {

		contactService.save(contact);
		return contact;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@RequestBody Contact contact, @PathVariable Long id) {

		contactService.save(contact);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {

		Contact contact = contactService.findById(id);
		contactService.delete(contact);
	}
}
