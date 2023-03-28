package com.ocr.backend.service.impl;

import com.ocr.backend.config.jwt.JwtUtils;
import com.ocr.backend.config.services.UserDetailsImpl;
import com.ocr.backend.dao.UserDAO;
import com.ocr.backend.dto.UserMapper;
import com.ocr.backend.model.User;
import com.ocr.backend.payload.JwtResponse;
import com.ocr.backend.payload.SingupRequest;
import com.ocr.backend.dto.UserDTO;
import com.ocr.backend.service.UserService;
import com.ocr.backend.exeption.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

  private final UserMapper modelMapper;

  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  private final UserDAO userDAO;

  private final AuthenticationManager authenticationManager;

  private final JwtUtils jwtUtils;


  public UserServiceImpl(UserDAO userDAO, AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserMapper modelMapper) {
    this.userDAO = userDAO;
    this.authenticationManager = authenticationManager;
    this.jwtUtils = jwtUtils;
    this.modelMapper = modelMapper;

  }

  @Override
  @Transactional
  public User createUser(SingupRequest singupRequest) {
    if (userDAO.findByEmail(singupRequest.getEmail()).isPresent()) {
      throw new IllegalArgumentException("User already exists: " + singupRequest.getEmail());
    }
    String password = encoder.encode(singupRequest.getPassword());
    singupRequest.setPassword(password);
    singupRequest.setCreatedAt(LocalDate.now());

    return userDAO.save(modelMapper.toEntity(singupRequest));
  }

  @Override
  public UserDTO findById(long id) {
    User user = this.userDAO.findById(id).orElseThrow(() -> new NotFoundException("User with this Id not found"));
    return modelMapper.toDto(user);
  }

  @Override
  public Boolean existsByEmail(String email) {
    return this.userDAO.existsByEmail(email);
  }

  @Override
  public UserDTO getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      String currentUserName = authentication.getName();
      User user = userDAO.findByEmail(currentUserName).orElseThrow(() -> new NotFoundException("User with this Mail not found"));
      return modelMapper.toDto(user);
    }
    return null;
  }

  public ResponseEntity<?> createToken(String mail, String password) {
      Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(mail, password));

      SecurityContextHolder.getContext().setAuthentication(authentication);
      String jwt = jwtUtils.generateJwtToken(authentication);
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getName(), userDetails.getUsername()));
  }


}
