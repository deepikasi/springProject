package com.hcl;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class MainController {
	@Autowired
	ServiceIntf service;

	@RequestMapping(value = "/")
	public ModelAndView funOne() {
		return new ModelAndView("begin");
	}

	@RequestMapping(value = "/save")
	public ModelAndView createUser(@ModelAttribute User user) {
		System.out.println("Come to controller");
		service.createUser(user);
		return new ModelAndView("redirect:/list");

	}

	@RequestMapping(value = "/list")
	public ModelAndView listUser(@ModelAttribute("users") User users) {

		List<User> user = service.listUser(users);
		return new ModelAndView("list", "User", user);

	}

	@RequestMapping(value = "/Delete")
	public ModelAndView deleteUser(HttpServletRequest request, @ModelAttribute("user") User user) {
		int id2 = Integer.parseInt(request.getParameter("id"));
		service.deleteById(id2);
		return new ModelAndView("redirect:/list");
	}

	@RequestMapping("/Edit")
	public ModelAndView editUser(HttpServletRequest request, @ModelAttribute("user") User user) {
		List<User> list = service.allUser();
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		User u = service.editById(id);
		ModelAndView modelAndView = new ModelAndView("Edit", "list", list);
		modelAndView.addObject("user", u);
		return modelAndView;
	}

	@RequestMapping("/Update")
	public ModelAndView updateUser(@ModelAttribute("user") User user, HttpServletRequest request) {
		System.out.println();
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		service.updateById(id, user);
		return new ModelAndView("redirect:/list");
	}

}