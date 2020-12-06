package com.assignment.retail.service.impl;

import org.springframework.stereotype.Service;

import com.assignment.retail.service.DiscountService;

@Service
public class CustomerServiceImpl implements DiscountService {

	@Override
	public double discount() {
		return 5.0;
	}

}
