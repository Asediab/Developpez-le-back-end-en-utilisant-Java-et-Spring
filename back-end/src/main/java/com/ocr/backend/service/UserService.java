package com.ocr.backend.service;

import com.ocr.backend.model.User;
import com.ocr.backend.payload.SingupRequest;
import com.ocr.backend.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

  User createUser(SingupRequest singupRequest);
  UserDTO findById(long id);

  Boolean existsByEmail(String email);
  UserDTO getCurrentUser();
  ResponseEntity<?> createToken (String mail, String password);
}
