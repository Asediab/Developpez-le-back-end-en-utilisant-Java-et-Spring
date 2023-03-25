package com.ocr.backend.rentals.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

  String saveFile(MultipartFile file);
}
