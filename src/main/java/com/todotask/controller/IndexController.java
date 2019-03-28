package com.todotask.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.todotask.exception.CustomGenericException;
import com.todotask.model.Author;
import com.todotask.model.Book;
import com.todotask.model.Login;
import com.todotask.model.User;
import com.todotask.services.BookService;
import com.todotask.services.UserService;

@Controller
public class IndexController {

	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/")
	public ModelAndView welcomepage() {
		ModelAndView mav = new ModelAndView("homepage");
		User user= (User) session.getAttribute("user");
		if(user!=null) {
			mav.addObject("person", user);
		}
		return mav;
	}
	
	@RequestMapping("/signup")
	public String welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "signup";
	}
	
	@RequestMapping("/logout")
	public String Logout() {
		session.invalidate();
		return "homepage";
	}
	
	@RequestMapping("books")
	public ModelAndView books() {
		User user= (User) session.getAttribute("user");
		if(user==null)
		{
//			bookService.inserDao();
			ModelAndView mav = new ModelAndView("homepage");
			mav.addObject("msg", "Please login first!");
			return mav;
		} else {
			List<Author> author =bookService.findAllAuthors();
			if(author.size()<1)
				bookService.inserDao();
			ModelAndView mav = new ModelAndView("books");
			mav.addObject("person",user);
			List<Author> authorList = bookService.findAllAuthors();
			mav.addObject("mode", "MODE_REGISTER");
			mav.addObject("authorList",authorList);
			return mav;
		}
	}
	
	@RequestMapping("/user-login")
	public ModelAndView login(@Valid @ModelAttribute("login")Login login, BindingResult result) {
		ModelAndView mav= new ModelAndView("homepage");
		User user = userService.login(login);
		if(user!=null) {
			user.setPassword("");
			user.setSaltKey("");
			session.setAttribute("user", user);
			mav.addObject("person",user);
		}
		else
		{
			mav.setViewName("result");
		}
		return mav;
	}

	@RequestMapping("allbooks")
	public ModelAndView viewAllBooks() {
		ModelAndView mav = new ModelAndView("allbooks");
		List<Book> books = bookService.findAllBooks();
		mav.addObject("books", books);
		return mav; 
	}

	@RequestMapping("/delete-book")
	public ModelAndView deleteBook(@RequestParam int id) {
		bookService.deleteBook(id);
		ModelAndView mav = new ModelAndView("allbooks");
		List<Book> books = bookService.findAllBooks();
		mav.addObject("books", books);
		return mav;
	}

	@RequestMapping("/edit-book")
	public ModelAndView editUser(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("books");
		Book book=bookService.findBookById(id);
		mav.addObject("book", book);
		mav.addObject("mode", "MODE_UPDATE");
		List<Author> authorList = bookService.findAllAuthors();
		mav.addObject("selectedCatId", book.getAuthor().getId());
		mav.addObject("authorList",authorList);
		return mav;
	}
	
	@RequestMapping("/contact")
    public String showEmailsPage() {
        return "contact";
    }
	
	/**
	 * This method calls a micro-service to get user by passing user id
	 * In  future we can use this to retrieve data of perticular user
	 * eg. List of movies seen by user
	 * @return
	 */
	@RequestMapping("allusers")
	public ModelAndView viewAllUsers() throws Exception{
		User user= (User) session.getAttribute("user");
		if(user==null)
		{
			ModelAndView mav = new ModelAndView("homepage");
			mav.addObject("msg", "Please login first!");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("allusers");
			try {
			User u = restTemplate.getForObject("http://localhost:5053/getuser/"+ user.getuId(),User.class);
			List<User> users = new ArrayList<User>();
			users.add(u);
			mav.addObject("users", users);
			}catch (Exception e) {
				throw new CustomGenericException("IO01", "Please check your user-service is running on localhost:5053");
			}
			return mav; 
			
		}
		
	}
}

