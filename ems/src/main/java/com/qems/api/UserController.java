package com.qems.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qems.data.model.User;
import com.qems.data.repo.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository repo;
	private static final String template = "Hello, %s!";

	@GetMapping("/users")
	@ResponseBody
	public List<User> listAll(Model model) {
		List<User> listUsers = repo.findAll();
		//model.addAttribute("listUsers", listUsers);
		//return "users";
		//return  String.format(template, "World") ;
		User u = new User("hishamsharif@yahoo.com","123");
		listUsers = new ArrayList<User>( );
		listUsers.add(u);
		
		return listUsers;
	}
	
	
	 
 

}