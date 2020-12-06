package com.assignment.retail.factory;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.retail.constants.RoleConstants;
import com.assignment.retail.service.DiscountService;
import com.assignment.retail.service.impl.AffiliateServiceImpl;
import com.assignment.retail.service.impl.CustomerServiceImpl;
import com.assignment.retail.service.impl.EmployeeServiceImpl;

@Component
public class DiscountFactory {

	final private Map<String, DiscountService> map = new HashMap<>();

	@Autowired
	AffiliateServiceImpl affiliateServiceImpl;
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@PostConstruct
	public void fillMap() {
		map.put(RoleConstants.AFFILIATE, affiliateServiceImpl);
		map.put(RoleConstants.CUSTOMER, customerServiceImpl);
		map.put(RoleConstants.EMPLOYEE, employeeServiceImpl);
	}

	public DiscountService getDiscountServiceObject(String role) {
		return map.get(role);

	}

}
