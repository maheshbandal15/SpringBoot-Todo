package com.todotask.dao;

import org.springframework.data.repository.CrudRepository;

import com.todotask.model.User;

public interface UserDao extends CrudRepository<User,Integer>{
	public User findUserByEmailId(String emilId);
}
