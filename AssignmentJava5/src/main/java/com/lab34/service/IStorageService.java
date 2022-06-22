package com.lab34.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
   public String storeFile(MultipartFile file);
   public Stream<Path> loadAll();
   public byte[] readFileContent(String fileName);
   public void deleteAllFiles();
}
