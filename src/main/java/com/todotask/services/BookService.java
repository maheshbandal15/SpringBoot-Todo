package com.todotask.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.todotask.model.Author;
import com.todotask.model.Book;

public interface BookService {

	public boolean addBook(Book book);
	public boolean updateBook(int bookId);
	public boolean deleteBook(int bookId);
	public List<Book> findBookbyTitle(String title);
	public List<Book> findAllBooks();
	public List<Author> findAllAuthors();
	public void inserDao();
	public boolean updateAuhor(Author author);
	public Author findAuthorById(int id);
	public Book findBookById(int id);
	public int updateBook(int bookId, String title, String publication
    		, String edition, double price, Author author);
}
