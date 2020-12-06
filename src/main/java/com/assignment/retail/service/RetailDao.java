package com.assignment.retail.service;

import java.util.Optional;

import com.assignment.retail.model.UserEntity;

public interface RetailDao {

	public Optional<UserEntity> fetchUserDetails(String userName);

}
