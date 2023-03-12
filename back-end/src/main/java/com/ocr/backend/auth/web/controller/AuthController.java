package com.ocr.backend.auth.web.controller;

import com.ocr.backend.auth.config.jwt.JwtUtils;
import com.ocr.backend.auth.config.services.UserDetailsImpl;
import com.ocr.backend.auth.service.UserService;
import com.ocr.backend.payload.JwtResponse;
import com.ocr.backend.payload.LoginRequest;
import com.ocr.backend.payload.MessageResponse;
import com.ocr.backend.payload.SingupRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@Tag(name = "Auth", description = "The Auth API. Contains all the operations that can be performed a Auth.")
public class AuthController {

  private final UserService service;
  private final AuthenticationManager authenticationManager;
  private final JwtUtils jwtUtils;


  public AuthController(UserService service, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
    this.service = service;
    this.authenticationManager = authenticationManager;
    this.jwtUtils = jwtUtils;
  }

  @Operation(summary = "Login an user")
  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    return createToken(loginRequest.getEmail(), loginRequest.getPassword());
  }
  @Operation(summary = "Create new user")
  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SingupRequest signUpRequest) {
    if (service.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: Email is already taken!"));
    }

    service.createUser(signUpRequest);

    return createToken(signUpRequest.getEmail(), signUpRequest.getPassword());
  }

  private ResponseEntity<?> createToken(String mail, String password) {
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(mail, password));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    return ResponseEntity.ok(new JwtResponse(jwt,
      userDetails.getId(),
      userDetails.getName(),
      userDetails.getUsername(),
      userDetails.getUpdatedAt(),
      userDetails.getUpdatedAt()));
  }
}
