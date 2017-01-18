package com.vsii.spring.bookstore.service.impl.test;

import org.springframework.stereotype.Service;

import com.vsii.spring.bookstore.model.Account;
import com.vsii.spring.bookstore.service.AccountService;
import com.vsii.spring.bookstore.service.exception.AuthenticationException;


@Service("accountService")
public class AccountServiceImpl implements AccountService{

	@Override
	public void auth(Account account) throws AuthenticationException {

		if(account.getUsername() != null  && account.getUsername().equals(account.getPassword())) {
			return;
		}
		throw new AuthenticationException("Access denied!");
	}
	
}
