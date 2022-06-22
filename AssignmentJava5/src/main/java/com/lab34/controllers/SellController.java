package com.lab34.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lab34.entities.Hair;
import com.lab34.service.IStorageService;
import com.lab34.service.implement.HairService;

@Controller
public class SellController {
	
	@Autowired
	private HairService service;
	@GetMapping("sale")
	public String sale(Model model) {
		
		model.addAttribute("view","/views/sell.jsp");
		List<Hair> listHair =service.findAll();
		model.addAttribute("list",listHair);
		return "layout";
	}
}
