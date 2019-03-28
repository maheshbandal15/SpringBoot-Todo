package com.todotask.helper;

import com.todotask.model.Login;
import com.todotask.model.User;

public interface SecurePassword {
	
	public User hashSaltPaswword(User user);
	public  User authenticateUser(User user,Login login) throws Exception;
}
