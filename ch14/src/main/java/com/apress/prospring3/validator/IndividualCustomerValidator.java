package com.apress.prospring3.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.apress.prospring3.validator.domain.Customer;

public class IndividualCustomerValidator implements ConstraintValidator<CheckIndividualCustomer, Customer> {

	/**
	 * Nothing to do
	 */
	public void initialize(CheckIndividualCustomer constraintAnnotation) {

	}

	public boolean isValid(Customer customer, ConstraintValidatorContext context) {

		if(customer.getCustomerType() == null) return false;
		if(!customer.isIndividualCustomer()) return false;
		if(customer.getLastName() == null || customer.getGender() == null) return false;
		return true;
	}

}
