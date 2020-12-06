package com.assignment.retail.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.retail.model.UserEntity;
import com.assignment.retail.repository.UserRepository;
import com.assignment.retail.service.RetailDao;

@Service
public class RetailDaoImpl implements RetailDao {

	@Autowired
	UserRepository userRepository;

	@Override
	public Optional<UserEntity> fetchUserDetails(String userName) {
		return userRepository.findById(userName);
	}

}
