package com.todotask.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@Column
	private String qualification;

	@Column
	private String organisation;

	@Column(unique = true, length = 100)
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private Set<Book> books;

	public Author() {
		// TODO Auto-generated constructor stub
	}
		
	public Author(String name, String qualification, String organisation, String email) {
		super();
		this.name = name;
		this.qualification = qualification;
		this.organisation = organisation;
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", qualification=" + qualification + ", organisation="
				+ organisation + ", email=" + email + ", books=" + books + "]";
	}
	
	

}
