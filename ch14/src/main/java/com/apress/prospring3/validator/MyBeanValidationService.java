package com.apress.prospring3.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.prospring3.validator.domain.Customer;

@Service("myBeanValidationService")
public class MyBeanValidationService {

	@Autowired
	private Validator validator;
	
	public Set<ConstraintViolation<Customer>> validate(Customer customer){
		return validator.validate(customer);
	}
}
