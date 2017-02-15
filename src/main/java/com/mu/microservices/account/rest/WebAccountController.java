package com.mu.microservices.account.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mu.microservices.account.model.Account;
import com.mu.microservices.account.service.WebAccountService;

@RestController
public class WebAccountController {

	@Autowired
	private WebAccountService accountService;

	@RequestMapping(value = "/accounts/{id}", produces = "application/json")
	public Account getAccountById(@PathVariable Long id) {
		return accountService.getAccountById(id);
	}

	@RequestMapping(value = "/accounts/owner/{ownerName}", produces = "application/json")
	public List<Account> getOwnerAccounts(@PathVariable String ownerName) {
		return accountService.getOwnerAccounts(ownerName);
	}

}
