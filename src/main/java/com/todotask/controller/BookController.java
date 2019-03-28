package com.todotask.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.todotask.model.Book;
import com.todotask.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
 	
	@Autowired
	private BookService bookService;
	
	public BookController() {
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		/*This will disable data binding for id*/
//		binder.setDisallowedFields(new String[] {"id"});
		binder.setDisallowedFields(new String[] {"author"});
//		binder.setDisallowedFields(new String[] {"price"});
//		binder.setDisallowedFields(new String[] {"author.id"});
	}
	
	@RequestMapping("/addbook")
	public ModelAndView addBook(@Valid @ModelAttribute("book") Book book,@RequestParam("author") String authorId,
			 /*@RequestParam("price") String price,*/ BindingResult result) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println(Integer.parseInt(authorId));
		book.setAuthor(bookService.findAuthorById(Integer.parseInt(authorId)));
		boolean retVal= bookService.addBook(book);
		if(retVal)
			mav.addObject("msg", "Book added successfully!");
		else
			mav.addObject("msg","Bood add Failed");
		return mav;
	}
	
	@RequestMapping("/book-update")
	public ModelAndView updateBook(@Valid @ModelAttribute("book") Book book,@RequestParam("author") String authorId,
			@RequestParam("price") String price, BindingResult result) {
		ModelAndView mav = new ModelAndView("result");
		book.setPrice(Integer.parseInt(price));
		book.setAuthor(bookService.findAuthorById(Integer.parseInt(authorId)));
		int retVal=bookService.updateBook(book.getBookId(), book.getTitle(), book.getPublication(),
				book.getEdition(), book.getPrice(), book.getAuthor());
		System.out.println(retVal);
		mav.addObject("msg", "Book Updated successfully!");
		return mav;
	}
	
}
