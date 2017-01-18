package com.apress.prospring3;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.validator.MyBeanValidationService;
import com.apress.prospring3.validator.domain.Customer;

public class TestSpringValidator {

	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:META-INF/spring/spring-validator-app-context.xml");
		context.refresh();

		/*Contact contact = new Contact();
		contact.setFirstName(null);
		contact.setLastName("Ho");

		Validator contactValidator = context.getBean("contactValidator", Validator.class);
		BeanPropertyBindingResult result = new BeanPropertyBindingResult(contact, "Clarence");
		ValidationUtils.invokeValidator(contactValidator, contact, result);

		List<ObjectError> errors = result.getAllErrors();
		System.out.println("No of validation errors: " + errors.size());
		for (ObjectError error : errors) {
			System.out.println(error.getCode());
		}*/
		
		Customer customer = new Customer();
		customer.setFirstName("Pete");
		customer.setLastName("Hammer");
		customer.setCustomerType(null);
		customer.setGender(null);
		
		MyBeanValidationService myBeanValidationService = context.getBean("myBeanValidationService", MyBeanValidationService.class);
		validateCustomer(customer, myBeanValidationService);

		context.close();
	}

	private static void validateCustomer(Customer customer, MyBeanValidationService myBeanValidationService) {

		Set<ConstraintViolation<Customer>> violations = myBeanValidationService.validate(customer);
		listViolations(violations);
	}

	private static void listViolations(Set<ConstraintViolation<Customer>> violations) {

		System.out.println("No. of violations: " + violations.size());
		for (ConstraintViolation<Customer> violation : violations) {
			System.out.println("Validation error for property: " + violation.getPropertyPath() + " with value: "
					+ violation.getInvalidValue() + " with error message: " + violation.getMessage());
		}
	}
}
