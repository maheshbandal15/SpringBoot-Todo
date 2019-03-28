package com.todotask.helper;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todotask.model.Login;
import com.todotask.model.User;

@Component
public class SecurePasswordImpl implements SecurePassword 
{
	@Autowired
	User user;
	
	public SecurePasswordImpl() {
		// TODO Auto-generated constructor stub
	}
	public User hashSaltPaswword(User user) {
		// TODO Auto-generated method stub
		try {
			String salt = getNewSalt();
			String encryptedPassword = getEncryptedPassword(user.getPassword(), salt);
			user.setPassword(encryptedPassword);
			user.setSaltKey(salt);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	
	// returns base64 encoded salt
		private String getNewSalt() throws Exception
		{
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			byte [] salt = new byte[8];
			random.nextBytes(salt);
			return Base64.getEncoder().encodeToString(salt);
		}
		
		// Get a encrypted password using PBKDF2 hash algorithm
		private String getEncryptedPassword(String password, String salt) throws Exception
		{
			String algorithm= "PBKDF2WithHmacSHA1";
			int derivedKeylength = 160; //for SHA1
			int iterations= 20000; //NIST specifies 10000
			byte[] saltBytes = Base64.getDecoder().decode(salt);
			KeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, iterations, derivedKeylength);
			SecretKeyFactory f= SecretKeyFactory.getInstance(algorithm);
			byte [] encBytes= f.generateSecret(spec).getEncoded();
			return Base64.getEncoder().encodeToString(encBytes);		
		}


		public User authenticateUser(User user, Login login) throws Exception {
			// TODO Auto-generated method stub
			
			String salt= user.getSaltKey();
			String calculatedHash = getEncryptedPassword(login.getPassword(), salt);
			if(calculatedHash.equals(user.getPassword()))
			{
				return user;
			}
			else
			return null;
		}

}
