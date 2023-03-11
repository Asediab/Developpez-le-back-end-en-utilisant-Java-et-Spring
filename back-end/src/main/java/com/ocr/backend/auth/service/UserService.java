package com.ocr.backend.auth.service;

import com.ocr.backend.payload.SingupRequest;
import com.ocr.backend.auth.dto.UserDTO;

public interface UserService {

  void createUser(SingupRequest singupRequest);
  UserDTO findById(long id);

  Boolean existsByEmail(String email);
}
