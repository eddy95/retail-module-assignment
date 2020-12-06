package com.assignment.retail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.retail.service.RetailService;

@RestController
public class RetailController {

	@Autowired
	RetailService retailService;

	@GetMapping(value = "/fetchBill/{userName}")
	public double fetchBill(@PathVariable String userName) {
		return retailService.fetchBill(userName);
	}

}
