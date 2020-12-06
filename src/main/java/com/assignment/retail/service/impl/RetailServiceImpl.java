package com.assignment.retail.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.retail.model.UserEntity;
import com.assignment.retail.service.RetailDao;
import com.assignment.retail.service.RetailService;
import com.assignment.retail.util.BillGeneration;

@Service
public class RetailServiceImpl implements RetailService {

	@Autowired
	private RetailDao retailDao;

	@Autowired
	private BillGeneration billGeneration;

	@Override
	public double fetchBill(String userName) {
		Optional<UserEntity> user = retailDao.fetchUserDetails(userName);
		return billGeneration.generateBill(user);
	}

}
