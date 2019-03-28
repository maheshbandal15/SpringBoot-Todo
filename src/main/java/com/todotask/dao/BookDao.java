package com.todotask.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.todotask.model.Author;
import com.todotask.model.Book;

public interface BookDao extends CrudRepository<Book, Integer>{
	public List<Book> findBytitle(String title);
	//public Book findByBookId(int id);
	
//	@Modifying(clearAutomatically = true)
//    @Query("UPDATE Book c SET c.bookName= :bookName, c.publication= :publication, c.price= :price, c.edition= :edition, c.author= :author WHERE c.bookId = :bookId ")
//    public int updateBook(@Param("bookId") int bookId, @Param("bookName") String bookName, @Param("publication") String publication
//    		, @Param("edition") String edition, @Param("price") double price, @Param("author") Author author);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE Book c SET c.title= :title, c.publication= :publication, c.price= :price, c.edition= :edition, c.author= :author WHERE c.bookId = :bookId ")
    public int updateBook(int bookId, String title, String publication
    		, String edition, double price, Author author);
}
