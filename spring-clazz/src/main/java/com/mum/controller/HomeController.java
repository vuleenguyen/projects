package com.mum.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private final static Logger logger = Logger.getLogger(HomeController.class);
//	@RequestMapping("/")
//	@ResponseBody String home() {
//		return "Hello World";
//	}
	
	@RequestMapping("/")
	ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "Hello Java Clazz");
		logger.info("Customer Logged on here");
		return mv;
	}
	
	@RequestMapping("/login")
	ModelAndView login(@RequestParam(value="error", required=false)String error) {
		logger.info("Customer tried to login");
		ModelAndView mv = new ModelAndView("login");
		if (error != null) {
			mv.addObject("error", "Wrong name or password!");
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getName() != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/user")
	ModelAndView forUser() {
		ModelAndView mv = new ModelAndView("index");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mv.addObject("message", "Hello User " + auth.getName());
		logger.info("Customer login successfully");
		return mv;
	}
}
