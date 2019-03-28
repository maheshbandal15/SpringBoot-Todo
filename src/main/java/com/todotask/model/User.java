package com.todotask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="UserTable")
public class User {

	@Id
	@GeneratedValue
	private int uId;
	
	@NotNull
	private String userName;
	
	@Size(max=30)
	private String firstName;
	
	@Size(max=30)
	private String lastName;
	
	@NotNull
	//@Size(max=10)
	private int mobileNumber;
	
	@Size
	private String emailId;
	
	@NotNull
	@Size(min=5,max=30)
	private String password;
	private String saltKey;
	
	/*@Column(name="CreateDate")
	Default
	private Date date;*/
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String firstName, String lastName, int mobileNumber, String emailId, String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
	}

	public int getuId() {
		return uId;
	}
	public void setuId(int id) {
		this.uId = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	public String getSaltKey() {
		return saltKey;
	}
	public void setSaltKey(String saltKey) {
		this.saltKey = saltKey;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", emailId=" + emailId + ", password=" + password + ", saltKey=" + saltKey + "]";
	}
}
