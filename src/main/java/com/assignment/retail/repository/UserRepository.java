package com.assignment.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.retail.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}