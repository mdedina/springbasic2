package application.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	int count = 0;
	
	@RequestMapping("/new")
	public String newUser(){
		return "new";
	}
	
	@RequestMapping(value = "/create", method=RequestMethod.POST)
	/*
	 * To avoid duplicate POSTs on refresh, redirect to the result page.
	 * Setting model attributes here causes them to be passed as GET parameters
	 * in the redirect.
	 */
	public String createUser(HttpServletRequest req, Model model){
		count++;
		req.getSession().setAttribute("count", Integer.toString(count));
		model.addAttribute("name", req.getParameter("name"));
		model.addAttribute("location", req.getParameter("location"));
		model.addAttribute("language", req.getParameter("language"));
		model.addAttribute("comment", req.getParameter("comment"));
		return "redirect:result";
	}
	
	@RequestMapping(value = "/result", method=RequestMethod.GET)
	public String showUser(HttpServletRequest req, Model model) {
		model.addAttribute("name", req.getParameter("name"));
		model.addAttribute("location", req.getParameter("location"));
		model.addAttribute("language", req.getParameter("language"));
		model.addAttribute("comment", req.getParameter("comment"));
		return "result";
	}
}
