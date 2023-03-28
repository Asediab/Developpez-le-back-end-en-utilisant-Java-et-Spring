package com.ocr.backend.service.impl;

import com.ocr.backend.exeption.NotFoundException;
import com.ocr.backend.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileUploadImpl implements FileUploadService {

  @Value("${upload.path.img}")
  private String uploadPath;

  @Override
  public String saveFile(MultipartFile file) {
    if (file != null) {
      return upload(file);
    }
    return "http://localhost:8080/api/" + uploadPath + "/" + "file_not_exist";
  }

  private String upload(MultipartFile file){
    File uploadDirectory = new File(uploadPath);
    if (!uploadDirectory.exists()) {
      uploadDirectory.mkdirs();
    }
    try {
      Path paths = Paths.get(uploadPath).toAbsolutePath().normalize();
      Path targetLocation = paths.resolve(Objects.requireNonNull(file.getOriginalFilename()));

      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

      return "http://localhost:8080/api/" + uploadPath + "/" + file.getOriginalFilename();
    } catch (IOException e) {
      throw  new NotFoundException("Could not store file " + file.getOriginalFilename() + ". Please try again!");
    }
  }
}
