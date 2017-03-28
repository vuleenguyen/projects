package com.edu.mum.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.mum.dao.GroupDAO;
import com.edu.mum.dao.UserDAO;
import com.edu.mum.dao.model.User;

@Controller
@RequestMapping("/account")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private GroupDAO groupDAO;

	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/add")
	public ModelAndView addForm() {
		User user = new User();
		ModelAndView modelAndView = new ModelAndView("user.form", "command", user);
		modelAndView.addObject("group", groupDAO.list(null));
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView addNewAccount(@Valid @ModelAttribute("command") User user, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("user.form", "command", new User());
			modelAndView.addObject("group", groupDAO.list(null));
			modelAndView.addObject("error", result);
			return modelAndView;
		}
		LOGGER.info("add new user ----- >" + user);
		userDAO.addUser(customUser(user));
		return new ModelAndView("redirect:/account/add");
	}
	
	private User customUser(User user) {
		String groupInput = user.getGroupToInput();
		int groupId = groupDAO.find(groupInput);
		user.setGroupId(groupId);
		return user;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView accounts(@RequestParam Integer groupId) {
		ModelAndView mv = new ModelAndView("user.list");
		mv.addObject("users", userDAO.list(groupId));
		return mv;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView accountDetail(@RequestParam String username) {
		ModelAndView mv = new ModelAndView("user.detail");
		mv.addObject("user", userDAO.findUser(username));
		return mv;
	}
}
