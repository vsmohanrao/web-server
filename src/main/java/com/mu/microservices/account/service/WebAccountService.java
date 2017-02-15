package com.mu.microservices.account.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mu.microservices.account.model.Account;

@Service
public class WebAccountService {

	public static final String ACCOUNTS_SERVICE_ID = "http://ACCOUNTS-SERVICE";

	@Autowired
	protected RestTemplate restTemplate;


	public Account getAccountById(Long id) {

		return restTemplate.getForObject(
				ACCOUNTS_SERVICE_ID + "/accounts/{id}", Account.class, id);
	}

	public List<Account> getOwnerAccounts(String ownerName) {
		Account[] accounts = restTemplate.getForObject(ACCOUNTS_SERVICE_ID
				+ "/accounts/owner/{ownerName}", Account[].class, ownerName);
		return accounts == null ? Collections.emptyList() : Arrays
				.asList(accounts);
	}

}
