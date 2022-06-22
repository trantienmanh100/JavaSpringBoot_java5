package com.lab34.controllers;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab34.entities.User;
import com.lab34.repository.IUserrepository;
import com.lab34.service.SessionService;
import com.lab34.utils.EnCryptUtil;



@Controller
public class UserController {
	@Autowired
	IUserrepository userRep;
	@Autowired
	HttpServletRequest request;
	@Autowired
	SessionService session;
	@GetMapping("login")
	public String viewLogin() {
		return "login";
	}
	@PostMapping("login")
	public String login(Model model, @RequestParam(name="email") String email,
			@RequestParam(name="password") String password) {
		User user =userRep.findByEmail(email);
		boolean check = EnCryptUtil.check(password, user.getPassword());
		if (check == true) {
			// Đăng nhập thành công
			System.out.println("Đăng nhập thành công");
			session.set("idUser", user.getId());
			model.addAttribute("user",user);
			if (user.getRole()==1) {
				// admin
				return "redirect:/hair/list";
			} else {
				return "redirect:/hair/sale";
				
			}
				
		} else {
			System.out.println("Đăng nhập thất bại");
			// Đăng nhập thất bại
			return "login";
		}
	}
	
	@PostMapping("save-user")
	public String saveUser(Model model,
			@RequestParam(name="password") String password,
			@RequestParam(name="email") String email,
			@RequestParam(name="fullName") String fullName,
			@RequestParam(name="telephone") String telephone,
			@RequestParam(name="address") String address) {
		try {
			User entity = new User();
			//BeanUtils.populate(entity, request.getParameterMap());
			String encrypted = EnCryptUtil.encrypt(
				password
			);
			
			entity.setPassword(encrypted);
			entity.setAddress(address);
			entity.setCreateAt(new Date());
			entity.setEmail(email);
			entity.setFullName(fullName);
			entity.setRole(0);
			entity.setTelephone(telephone);
			userRep.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/login";
	}
	@GetMapping("register")
	public String register() {
		
		return "register";
	}
	@GetMapping("logout")
	public String logout() {
		
		session.remove("user");
		return "login";
	}
}
