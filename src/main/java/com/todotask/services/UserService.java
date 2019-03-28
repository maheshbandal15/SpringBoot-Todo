package com.todotask.services;

import com.todotask.model.Login;
import com.todotask.model.User;

public interface UserService {
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public User findUser(Integer uId);
	public User login(Login login);
}
