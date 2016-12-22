package com.appdirect.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdirect.service.AccountService;

@RequestMapping(value = "api/v1/employees")
@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String getEmployees() {
		return accountService.test();
	}

	@RequestMapping(value = "/eventlistner", method = RequestMethod.GET)
	public void analyzeEvent(@RequestParam(value = "eventUrl", required = false) String eventUrl) {
		// return accountService.test();
		logger.info("Event Url is :- " + eventUrl);

	}

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

}
