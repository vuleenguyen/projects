package com.edu.mum.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.mum.dao.GroupDAO;
import com.edu.mum.dao.model.Group;

@Controller
@RequestMapping("/group")
public class GroupController {
	private static final Logger LOGGER = Logger.getLogger(GroupController.class);
	
	@Autowired
	private GroupDAO groupDAO;
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public ModelAndView addForm() {
		return new ModelAndView("group.form","command", new Group());
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView addGroup(@Valid @ModelAttribute("command") Group group, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("group","command",group);
			modelAndView.addObject("error", bindingResult);
			return modelAndView;
		}
		LOGGER.info("add new group--------> " + group);
		groupDAO.insert(group);
		return new ModelAndView("group");
		
	}
}
