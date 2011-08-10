package com.hdm.guestbook.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hdm.guestbook.dao.OverviewDao;
import com.hdm.guestbook.model.Overview;

@Controller
public class PostController {

	@Autowired
	private OverviewDao overviewDao;

	@RequestMapping(value = "/post")
	public ModelAndView guestbook(HttpServletRequest request) {
		// Handle a new guest (if any):
		String text = request.getParameter("textarea");
		if (text != null) {
			HttpSession session = request.getSession();
			String username = (String)session.getAttribute("username");
			overviewDao.persist(username, text, new Date(System.currentTimeMillis()));
			return new ModelAndView("redirect:overview.html");
		} else {
			return new ModelAndView("post.jsp", "overviewDao", overviewDao);
		}
		// Prepare the result view (guest.jsp):
	}
}