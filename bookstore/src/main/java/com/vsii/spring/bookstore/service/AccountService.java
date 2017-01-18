package com.vsii.spring.bookstore.service;

import com.vsii.spring.bookstore.model.Account;
import com.vsii.spring.bookstore.service.exception.AuthenticationException;

public interface AccountService {

	public void auth(Account account) throws AuthenticationException;
}
