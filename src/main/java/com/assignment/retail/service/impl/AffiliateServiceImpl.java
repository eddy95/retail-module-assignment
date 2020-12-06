package com.assignment.retail.service.impl;

import org.springframework.stereotype.Service;

import com.assignment.retail.service.DiscountService;

@Service
public class AffiliateServiceImpl implements DiscountService {

	@Override
	public double discount() {
		return 10.0;
	}

}
