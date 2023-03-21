package com.ocr.backend.auth.service;

import com.ocr.backend.payload.SingupRequest;
import com.ocr.backend.auth.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

  void createUser(SingupRequest singupRequest);
  UserDTO findById(long id);

  Boolean existsByEmail(String email);
  UserDTO getCurrentUser();
  ResponseEntity<?> createToken (String mail, String password);
}
