package formhandling.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@RequestMapping("/new")
	public String newUser(){
		return "new";
	}
	
	@RequestMapping(value = "/create", method=RequestMethod.POST)
	public String createUser(HttpServletRequest req){
		String name = req.getParameter("name");
		System.out.println("My name is " + name);
		return "result";
	}
}
