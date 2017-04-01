package com.edu.mum.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import com.edu.mum.dao.model.Group;

@Controller
@RequestMapping("/group")
public class GroupController {
	private static final Logger LOGGER = Logger.getLogger(GroupController.class);

	@Autowired
	private GroupDAO groupDAO;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addForm() {
		return new ModelAndView("group.form", "command", new Group());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addGroup(@Valid @ModelAttribute("command") Group group, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("group", "command", group);
			modelAndView.addObject("error", bindingResult);
			return "/save";
		}
		if (group.getId() > 0) {
			LOGGER.info("update group--------> " + group);
			groupDAO.update(group);
		} else {
			LOGGER.info("add new group--------> " + group);
			groupDAO.insert(group);
		}
		return "redirect:/group/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "q", required = false) String patternToFilter) {
		ModelAndView mv = new ModelAndView("group.list");
		mv.addObject("group", groupDAO.list(patternToFilter));
		return mv;
	}

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		if (id == null)
			return new ModelAndView("redirect:/group/list");
		groupDAO.delete(id);
		return new ModelAndView("redirect:/group/list");
	}

	@RequestMapping(value = "/update")
	public ModelAndView updateForm(@RequestParam(value = "id", required = true) Integer id) {
		Group group = groupDAO.find(id);
		if (group == null)
			return new ModelAndView("redirect:/group/list");
		return new ModelAndView("group.form", "command", group);
	}
}
