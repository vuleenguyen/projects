package com.edu.mum.controller;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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


	@Autowired
	private GroupDAO groupDAO;

	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/add")
	public ModelAndView addForm() {
		ModelAndView modelAndView = new ModelAndView("user.form", "command", new User());
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
		ModelAndView mv;
		try {
			mv = new ModelAndView("user.form", "command", new User());
			mv.addObject("group", groupDAO.list(null));
			if (user.isUpdate()) {
				/*=====================Update User=================*/
				userDAO.update(customUser(user));
				mv.addObject("happy", "Update User: " + user.getUserName() + " successully");
			} else {
				/*=====================Add User====================*/
				userDAO.addUser(customUser(user));
				mv.addObject("happy", "Save User: " + user.getUserName() + " successully");
			}
		} catch (Exception e) {
			mv = new ModelAndView("user.form");
			mv.addObject("error", e.getMessage());
		}
		return mv;
	}

	private User customUser(User user) throws Exception {
		user.setGroup(groupDAO.find(user.getGroupToInput()));
		return user;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView accounts(@RequestParam(required = false) Integer groupId,
			@RequestParam(name="q", required = false) String ageToFilter, @RequestParam(required = false) Integer page) {
		ModelAndView mv = new ModelAndView("user.list");
		Integer age = null;
		try {
			if (!StringUtils.isBlank(ageToFilter)) {
				age = Integer.parseInt(ageToFilter);
			}
		} catch (Exception ex) {
			mv.addObject("error", "Age is wrong");
			age = null;
		}
		mv.addObject("users", userDAO.list(groupId, age, page == null ? 1 : page));
		mv.addObject("average", "Average of Age is " + userDAO.averageAge());
		mv.addObject("pagination", Math.round(userDAO.list(groupId, age, null).size()/2.0));
		return mv;
	}

	@RequestMapping(value = "/detail")
	public ModelAndView accountDetail(@RequestParam String username) {
		ModelAndView mv = new ModelAndView("user.detail");
		mv.addObject("user", userDAO.findUser(username));
		return mv;
	}

	@RequestMapping(value = "/delete/{userName}")
	public ModelAndView deleteUser(@PathVariable("userName") String userName) {
		if (StringUtils.isBlank(userName)) 
			return new ModelAndView("redirect:/account/list"); 
		userDAO.delete(userDAO.findUser(userName));
		return new ModelAndView("redirect:/account/list");
	}

	@RequestMapping(value = "/update")
	public ModelAndView updateUser(@RequestParam String userName) {
		User userToUpdate = userDAO.findUser(userName);
		userToUpdate.setUpdate(true);
		userToUpdate.setGroupToInput(null);
		ModelAndView modelAndView = new ModelAndView("user.form", "command", userToUpdate);
		modelAndView.addObject("group", groupDAO.list(null));
		return modelAndView;
	}
	
	@RequestMapping(value = "/addMuch")
	public String addRandom() {
		userDAO.addBatch(groupDAO.list(null));
		return "redirect:/account/list";
	}
}
