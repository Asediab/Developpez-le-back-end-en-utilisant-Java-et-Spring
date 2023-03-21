package com.ocr.backend.rentals.service;

import com.ocr.backend.rentals.dto.RentalsDTO;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

  String saveFile(MultipartFile file);
}
