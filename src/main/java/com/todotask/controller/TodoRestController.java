package com.todotask.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.todotask.model.Login;
import com.todotask.model.User;
import com.todotask.services.UserService;

@RestController
@RequestMapping("/user")
public class TodoRestController {
	
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	private HttpSession session;
	
	/*public TodoRestController(UserService userService) {
		super();
		this.userService = userService;
	}*/

	@RequestMapping("/adduser")
	public ModelAndView addUser( @Valid @ModelAttribute("user") User user, BindingResult result) {
		ModelAndView mav=new ModelAndView("result");
		if(userService.addUser(user)) {
			user.setPassword("");
			user.setSaltKey("");
			session.setAttribute("user", user);
			mav.addObject("msg", "User Added Successfully..!!!"+"\n User details are "+user.toString());
			//mav.addObject(user);
		}
		else {
			mav.addObject("msg", "user add failed");			
		}
		return mav;
	}
	
//	@RequestMapping("/login")
//	public ModelAndView login(@Valid @ModelAttribute("login")Login login, BindingResult result) {
//		ModelAndView mav= new ModelAndView("homepage");
//		User user = userService.login(login);
//		if(user!=null) {
//			user.setPassword("");
//			user.setSaltKey("");
//			session.setAttribute("user", user);
//			mav.addObject("person",user);
//		}
//		else
//		{
//			mav.setViewName("result");
//		}
//		return mav;
//	}
}
