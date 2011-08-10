package com.hdm.guestbook.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hdm.guestbook.dao.LoginDao;
import com.hdm.guestbook.model.Login;

@Controller
public class RegisterController {

	Logger log = Logger.getLogger(RegisterController.class.getName());
	@Autowired
	private LoginDao loginDao;

	@RequestMapping(value = "/register")
	public ModelAndView guestbook(HttpServletRequest request) {
		Login login = new Login();
		ModelAndView mav = new ModelAndView("register.jsp");
		mav.addObject(login);

		String name = request.getParameter("name");
		if (name != null) {
			String password = request.getParameter("password");
			try {
				loginDao.register(new Login(name, password));
			} catch (DataIntegrityViolationException e) {
				log.warning("entity " + name + " already exists");
			}
		}
		// Handle a new guest (if any):
		//
		// if (name != null)
		// guestDao.persist(new Guest(name));

		// Prepare the result view (guest.jsp):
		// return new ModelAndView("login.jsp");
		// return new ModelAndView("guest.jsp", "guestDao", guestDao);
		return mav;
	}

}