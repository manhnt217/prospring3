package com.vsii.spring.bookstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vsii.spring.bookstore.model.Account;
import com.vsii.spring.bookstore.service.AccountService;
import com.vsii.spring.bookstore.service.exception.AuthenticationException;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("action", request.getRequestURI());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, params = { "username", "password" })
	public String login(Model model, Account account, RedirectAttributes redirectAttributes, HttpSession session)
			throws AuthenticationException {

		try {
			accountService.auth(account);
			session.setAttribute("account", account);
			return "redirect:/";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("exception", e);
			return "redirect:/login";
		}
	}
}
