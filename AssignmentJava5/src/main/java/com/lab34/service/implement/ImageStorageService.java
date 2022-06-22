package com.lab34.service.implement;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lab34.service.IStorageService;

@Service
public class ImageStorageService implements IStorageService{
	private final Path storageFolder =Paths.get("src/main/webapp/images");
	// constructer
	public ImageStorageService(){
	    try{
	        Files.createDirectories(storageFolder);
	    }catch(IOException exception){
	        throw new RuntimeException("cannot initialize storage",exception);
	   }
	}
	
	private boolean isImageFile(MultipartFile file){
		   // Let install FileNameUtils
		   String fileExtension=FilenameUtils.getExtension(file.getOriginalFilename());
		  // System.out.println(fileExtension);
		    return Arrays.asList(new String[]{"png","jpg","jpeg","bmp"})
		            .contains(fileExtension.trim().toLowerCase());
		}
	@Override
	public String storeFile(MultipartFile file) {
		try {
			if(file.isEmpty()) {
				throw new RuntimeException("Failed to store emty file.");
			}
			// check file is image
			if(!isImageFile(file)) {
				throw new RuntimeException("you can only upload image file");
			}
			// file must be<=5Mb
			float fileSizeInMegabytes=file.getSize()/1_000_000;
			if(fileSizeInMegabytes>5.0f){
			    throw new RuntimeException("File must be<=5Mb");
			}
			
		
		   // File must be rename,why?
		   String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
		   String generatedFileName = UUID.randomUUID().toString().replace("-","");
		   generatedFileName = generatedFileName+"."+fileExtension;
		   Path destinationFilePath = this.storageFolder.resolve(
		                 Paths.get(generatedFileName))
		          .normalize().toAbsolutePath();
		   if(!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath())){
		      throw new RuntimeException(
		             "Cannot store file outside current directory.");
		   }
		   try(InputStream inputStream=file.getInputStream()){
		       Files.copy(inputStream,destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
		   }
		   return generatedFileName;
			
		} catch (IOException e) {
			throw new RuntimeException("Failed to store file", e);
		}
		
		
	}

	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] readFileContent(String fileName) {
		try {
		Path file=storageFolder.resolve(fileName);
		Resource resource = new UrlResource(file.toUri());
		if(resource.exists()|| resource.isReadable()){
		    byte[]bytes = StreamUtils.copyToByteArray(resource.getInputStream());
		    return bytes;
		}
		else{
		    throw new RuntimeException(
		            "Could not read file: "+fileName);
		}
		}
		catch(IOException e){
		throw new RuntimeException("Could not read file:"+fileName,e);
		}
		
	}

	@Override
	public void deleteAllFiles() {
		// TODO Auto-generated method stub
		
	}
	
}
