package com.todotask.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todotask.dao.UserDao;
import com.todotask.helper.SecurePassword;
import com.todotask.model.Login;
import com.todotask.model.User;

@Service
@Transactional
public class UserServiceImpl implements  UserService{
	
//	@Autowired
	User user;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unused")
	@Autowired
	private final UserDao userDao;
	
	@Autowired
	SecurePassword securePas;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addUser(User user) {
		this.user= securePas.hashSaltPaswword(user);
		this.user= userDao.save(this.user);
		return (this.user!=null? true:false);
//		entityManager.persist(this.user);
//		return true;
		
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
//		return userDao.updateUser(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		 userDao.delete(user);
		return true;
	}

	@Override
	public User findUser(Integer uId) {
		// TODO Auto-generated method stub
		return userDao.findOne(uId);
	}

	@Override
	public User login(Login login) {
		user=userDao.findUserByEmailId(login.getEmailId());
		if (user != null) {
//			System.out.println("set user to session");
			System.out.println("Now authenticate user.");
			try {
				return securePas.authenticateUser(user, login);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
}
