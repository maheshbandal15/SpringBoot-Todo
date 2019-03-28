package com.todotask.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {

	@NotEmpty(message = "emailId cannot be blank")
	private String emailId;

	@NotEmpty(message = "password cannot be blank")
	private String password;

	public Login() {

	}
	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
