package com.lab34.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lab34.entities.ResponeObject;
import com.lab34.service.IStorageService;

@Controller
@RequestMapping(path="/api/v1/fileUpload")
public class FileUploadController {
	
	@Autowired
	private IStorageService storageService;
	@PostMapping("")
	
	public ResponseEntity<ResponeObject> uploadFile(@RequestParam("file") MultipartFile file){
		try {
			// save files to a folder
			String generatedFileName =storageService.storeFile(file);
			return ResponseEntity.status(HttpStatus.OK).body(
				   new ResponeObject("ok","upload file successfully", generatedFileName)
					);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
					   new ResponeObject("ok",e.getMessage(),"")
					);
			
		}
	}
	
	//getImageURL
	@GetMapping("/files/{fileName:.+}")
	public ResponseEntity<byte[]> readDetailFile(@PathVariable String fileName){
	
	   try{
	       byte[]bytes=storageService.readFileContent(fileName);
	       return ResponseEntity
	               .ok()
	               .contentType(MediaType.IMAGE_JPEG)
	               .body(bytes);
	   }catch(Exception exception){
	       return ResponseEntity.noContent().build();
	   }	
		
	}
}
