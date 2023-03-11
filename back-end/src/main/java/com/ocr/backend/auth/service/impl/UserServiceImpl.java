package com.ocr.backend.auth.service.impl;

import com.ocr.backend.auth.dao.UserDAO;
import com.ocr.backend.payload.SingupRequest;
import com.ocr.backend.auth.dto.UserDTO;
import com.ocr.backend.auth.model.User;
import com.ocr.backend.auth.service.UserService;
import com.ocr.backend.exeption.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

  private final ModelMapper modelMapper = new ModelMapper();

  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  private final UserDAO userDAO;

  public UserServiceImpl(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @Override
  public void createUser(SingupRequest singupRequest) {
    if (userDAO.findByEmail(singupRequest.getEmail()).isPresent()) {
      throw new IllegalArgumentException("User already exists: " + singupRequest.getEmail());
    }
    String password = encoder.encode(singupRequest.getPassword());
    singupRequest.setPassword(password);
    singupRequest.setCreatedAt(LocalDateTime.now());
    toDto(userDAO.save(toEntity(singupRequest)));
  }

  @Override
  public UserDTO findById(long id) {
    User user = this.userDAO.findById(id).orElseThrow(() -> new NotFoundException("User with this Id not found"));
    return toDto(user);
  }

  @Override
  public Boolean existsByEmail(String email) {
    return this.userDAO.existsByEmail(email);
  }

  private UserDTO toDto(User userToDto) {
    return modelMapper.map(userToDto, UserDTO.class);
  }

  private User toEntity(SingupRequest singupRequestToEntity) {
    return modelMapper.map(singupRequestToEntity, User.class);
  }
}
