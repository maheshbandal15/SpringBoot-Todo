package com.todotask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "book"/*, uniqueConstraints = { @UniqueConstraint(columnNames = "BookName") }*/)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	@Column(name = "BookName")
	private String title;

	@ManyToOne
//	@JoinColumn
	private Author author;

	@Column
	private String publication;

	@Column
	private int price;

	@Column
	private String edition;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getEdition() {
		return edition;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Author getAuthor() {
		return author;
	}

}
