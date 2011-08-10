package com.hdm.guestbook.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hdm.guestbook.dao.LoginDao;
import com.hdm.guestbook.model.Login;

@Controller
public class LoginController {

	Logger log = Logger.getLogger(LoginController.class.getName());
	@Autowired
	private LoginDao loginDao;
	
	private ModelAndView loginFailed() {
		return new ModelAndView("login.jsp");
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView guestbook(HttpServletRequest request) {
		ModelAndView mav = null;
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(name != null && password != null) {
			Login login = loginDao.getLoginByName(name);
			if(login.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.putValue("username", name);
				mav = new ModelAndView("redirect:overview.html");
			} else {
				mav = loginFailed();
			}
		} else {
			mav = new ModelAndView("login.jsp");
		}
		mav.addObject(new Login());
		// Handle a new guest (if any):
		// String name = request.getParameter("name");
		// if (name != null)
		// guestDao.persist(new Guest(name));

		// Prepare the result view (guest.jsp):
		//return new ModelAndView("login.jsp");
		// return new ModelAndView("guest.jsp", "guestDao", guestDao);
		return mav;
	}

}