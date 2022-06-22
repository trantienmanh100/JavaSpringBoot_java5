package com.lab34.controllers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lab34.entities.Hair;
import com.lab34.entities.HairType;
import com.lab34.repository.IHairRepository;
import com.lab34.service.IStorageService;
import com.lab34.service.implement.HairService;

@Controller
@RequestMapping("hair")
public class HairController {
	@Autowired
	private HairService service;
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext application;
	@Autowired
	private IStorageService storageService;
	
	@GetMapping("new")
	public String newForm(Model model, Hair hair) {
		
		model.addAttribute("hair",new Hair());
		model.addAttribute("view","hair.jsp");
		
		return "layoutAdmin";
	}
	@GetMapping("edit-hair/{id}")
	public String editHair(@PathVariable int id,Model model) {
		Optional<Hair> hair = service.findById(id);
		//System.out.println(hair.get().getId());
		Hair entity= hair.get();
		//System.out.println(entity); ông cụ tổ bug, in ra cũng lỗi được
		
		
		model.addAttribute("hair",entity);
		model.addAttribute("view","edit-hair.jsp");
		return "layoutAdmin";
	}
	@GetMapping("delete-hair/{id}")
	public String deleteHair(@PathVariable int id,Model model) {
		
		service.deleteById(id);
		
		return "forward:/hair/list";
	}
	
	@PostMapping("delete-multiple-hair")
	public String deleteMultipleHair(@RequestParam(value="select", required = false) List<Integer> list) {
		service.deleteAllByIdInBatch(list);
		
		return "redirect:/hair/list";
	}
	
	@GetMapping("list")
	public String getAll(Model model,
			@RequestParam(name = "pageNumber", defaultValue = "0", required = false )int pageNumber,
			@RequestParam(name="type",required = false)HairType type){
		Page<Hair> page;
		if(type==null) {
			page =service.listAll(pageNumber,5);
		}
		else {
			page = service.findByType(type,pageNumber,5);
		}
		
		model.addAttribute("type",type);
		model.addAttribute("page",page);
		model.addAttribute("view","hair-list.jsp");
		 return "layoutAdmin";
	}
	
	
	
	
	@GetMapping("sale")
	public String sale(Model model
			,@RequestParam(name = "pageNumber", defaultValue = "0", required = false )int pageNumber
			,@RequestParam(name="type",required = false)HairType type) {
		Page<Hair> page;
		if(type==null) {
		
		page =service.listAll(pageNumber,8);
		
		}
		else {
			page = service.findByType(type,pageNumber,8);
		}
		model.addAttribute("type",type);
		model.addAttribute("page",page);
		model.addAttribute("view","/views/sell.jsp");
		
		
		
		return "layout";
	}
	
	@GetMapping("search")
	public String searchByName(Model model ,
			@RequestParam(name="name",required = false) String name,
			@RequestParam(name = "pageNumber", defaultValue = "0", required = false )int pageNumber) {
		System.out.println("alo");
		Page<Hair> page;
		page =service.findByNameLike("%"+name+"%",pageNumber);
		model.addAttribute("page",page);
		model.addAttribute("view","/views/sell.jsp");
		return "layout";
	}
	
	
	
	
	
	@PostMapping("save")
	public String save(@Validated @ModelAttribute("hair") Hair hair,BindingResult result,
			Model model,@RequestParam(name="imageFile") MultipartFile file
			) {
		if(result.hasErrors()) {
			if(file.isEmpty()) {
				model.addAttribute("error_photo","Hãy chọn ảnh");
				
			}
			
			model.addAttribute("view","hair.jsp");
			
			return "layoutAdmin";
		}
		//System.out.println(file);
		try {
			// save files to a folder
			String generatedFileName =storageService.storeFile(file);
			hair.setImageUrl(generatedFileName);
			hair.setCreateDate(new Date());
			service.save(hair);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "redirect:/hair/list";
	}
	@PostMapping("update/{id}")
	public String update(@ModelAttribute("hair")  Hair hair,
			Model model ,@PathVariable int id
			,@RequestParam(name="imageFile") MultipartFile file) {
		Optional<Hair> hairop = service.findById(id);
		hair.setId(hairop.get().getId());
		try {
			// save files to a folder
			String generatedFileName =storageService.storeFile(file);
			hair.setImageUrl(generatedFileName);
			service.save(hair);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return "redirect:/hair/list";
		
		
	}
	@ModelAttribute("typeHair")
	public List<HairType> getType(){
		//List<HairType> list = null ;
		List<HairType> enumValues = Arrays.asList(HairType.values());
		return enumValues;
	}
	

		
}
