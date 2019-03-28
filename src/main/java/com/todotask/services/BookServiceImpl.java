package com.todotask.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todotask.dao.AuthorDao;
import com.todotask.dao.BookDao;
import com.todotask.helper.InsertAuthorHc;
import com.todotask.model.Author;
import com.todotask.model.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AuthorDao authorDao;
	
	@PersistenceContext
	private EntityManager entityManagerOne;
	
//	@Autowired
	Book book;
	
	public BookServiceImpl() {
		super();
	}
	/*public BookServiceImpl(BookDao bookDao, AuthorDao authorDao) {
		super();
		this.bookDao = bookDao;
		this.authorDao = authorDao;
	}*/


	@Override
	public boolean addBook(Book book) {
		book = bookDao.save(book);
		if(book!=null)
			return true;
		return false;
	}

	@Override
	public boolean updateBook(int bookId) {
		book = bookDao.findOne(bookId);
		if(book!=null) {
			book = bookDao.save(book);
			return true;
		}
			
		return false;
	}

	@Override
	public int updateBook(int bookId, String title, String publication, String edition, double price, Author author) {
//		int retVal = bookDao.updateBook(bookId, title, publication, edition, price, author);
		int retVal=0;
		//EntityManager entityManager=entityManager.getTransaction().begin();
		Query query = entityManagerOne.createQuery("Update Book c SET c.title= :title,"
				+ " c.publication= :publication, c.price= :price, c.edition= :edition,"
				+ " c.author= :author WHERE c.bookId = :bookId ");
		query.setParameter("bookId",bookId);
		query.setParameter("title",title);
		query.setParameter("publication",publication);
		query.setParameter("price",price);
		query.setParameter("edition",edition);
		query.setParameter("author",author);
		retVal=query.executeUpdate();
//		 em.getTransaction().commit();
//	      em.close();
		System.out.println(retVal);
		return retVal;
	}
	@Override
	public boolean deleteBook(int bookId) {
		bookDao.delete(bookId);
		return true;
	}

	@Override
	public List<Book> findBookbyTitle(String title) {
		List<Book> books = bookDao.findBytitle(title);
		return books;
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> books = (List<Book>) bookDao.findAll();
		for(Book b: books)
			System.out.println(b.toString());
		return books;
	}
	
	@Override
	public List<Author> findAllAuthors() { 
		List<Author> authors = (List<Author>) authorDao.findAll();
		return authors;
	}

	public void inserDao() {
		InsertAuthorHc in = new InsertAuthorHc();
		
		for(Author a: in.authorList)
		authorDao.save(a);
	}
	
	@Override
	public Author findAuthorById(int id) {
		Author a =authorDao.findOne(id);
		return a;
	}
	@Override
	public Book findBookById(int id) {
		return bookDao.findOne(id);
//		return bookDao.findByBookId(id);
	}
	@Override
	public boolean updateAuhor(Author author) {
		Author a =authorDao.save(author);
		return (a!=null)? true:false;
	}
}
