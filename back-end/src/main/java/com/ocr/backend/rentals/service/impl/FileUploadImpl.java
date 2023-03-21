package com.ocr.backend.rentals.service.impl;

import com.ocr.backend.exeption.NotFoundException;
import com.ocr.backend.rentals.dto.RentalsDTO;
import com.ocr.backend.rentals.service.FileUploadService;
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

  private static final String FILE_REGEX = "^\\p{ASCII}*.(png|jpg|gif|bmp)";
  @Override
  public String saveFile(MultipartFile file) {
    if (file != null) {
      return upload(file);
    }
    return uploadPath + "/" + "file_not_exist";
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

      return uploadPath + "/" + file.getOriginalFilename();
    } catch (IOException e) {
      throw  new NotFoundException("Could not store file " + file.getOriginalFilename() + ". Please try again!");
    }
  }
}
