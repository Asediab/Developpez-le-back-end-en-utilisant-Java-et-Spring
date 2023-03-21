package com.ocr.backend.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class JwtResponse {

  private String token;
  @JsonIgnore
  private String name;
  @JsonIgnore
  private String email;


  public JwtResponse(String accessToken, String name,String email) {
    this.email = email;
    this.name = name;
    this.token = accessToken;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
