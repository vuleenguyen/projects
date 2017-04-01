package com.edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "Hello Java Unit7");
		return mv;
	}

	@RequestMapping("/user")
	public ModelAndView user() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("message", "This is protected page!");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		if (error != null)
			mv.addObject("error", error);
		return mv;
	}

}
