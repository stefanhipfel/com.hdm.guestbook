package com.hdm.guestbook.controller;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hdm.guestbook.dao.OverviewDao;
 
@Controller
public class OverviewController {
	
	@Autowired
	private OverviewDao overviewDao;
	
    @RequestMapping(value="/overview")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
    	System.out.println("log: /overview");
        // Prepare the result view (guest.jsp):
        return new ModelAndView("overview.jsp", "overviewDao", overviewDao);
    }
}