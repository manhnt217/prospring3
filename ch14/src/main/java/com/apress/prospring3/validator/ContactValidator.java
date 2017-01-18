package com.apress.prospring3.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.apress.prospring3.domain.Contact;

@Component("contactValidator")
public class ContactValidator implements org.springframework.validation.Validator {

	public boolean supports(Class<?> clazz) {

		return Contact.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
	}
}
