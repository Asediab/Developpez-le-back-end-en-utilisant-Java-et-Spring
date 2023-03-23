package com.ocr.backend.auth.web.controller;

import com.ocr.backend.auth.dto.UserDTO;
import com.ocr.backend.auth.service.UserService;
import com.ocr.backend.payload.LoginRequest;
import com.ocr.backend.payload.MessageResponse;
import com.ocr.backend.payload.SingupRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@Tag(name = "Auth", description = "The Auth API. Contains all the operations that can be performed a Auth.")
public class AuthController {

  private final UserService service;

  public AuthController(UserService service) {
    this.service = service;
  }

  @Operation(summary = "Login an user")
  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    return service.createToken(loginRequest.getEmail(), loginRequest.getPassword());
  }
  @Operation(summary = "Create new user")
  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SingupRequest signUpRequest) {
    if (service.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: Email is already taken!"));
    }
    String password = signUpRequest.getPassword();
    service.createUser(signUpRequest);
    return service.createToken(signUpRequest.getEmail(), password);
  }

  @Operation(summary = "Get current login user")
  @SecurityRequirement(name = "Bearer Authentication")
  @GetMapping("/me")
  public ResponseEntity<?> getMe() {
    UserDTO userDTO = service.getCurrentUser();
    if (userDTO != null) {
      return ResponseEntity.ok(userDTO);
    }
    return ResponseEntity
      .badRequest()
      .body(new MessageResponse("Error: User not found"));
  }

}
