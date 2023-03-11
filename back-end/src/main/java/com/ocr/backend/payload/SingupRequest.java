package com.ocr.backend.payload;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class SingupRequest implements Serializable {
  private String email;

  private String name;

  private String password;

  private LocalDateTime createdAt;

  public SingupRequest() {
  }

  public SingupRequest(String email, String name, String password, LocalDateTime createdAt) {
    this.email = email;
    this.name = name;
    this.password = password;
    this.createdAt = createdAt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "UserCreateForm{" +
      "email='" + email + '\'' +
      ", name='" + name + '\'' +
      ", password='" + password + '\'' +
      ", createdAt=" + createdAt +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SingupRequest that)) return false;
    return email.equals(that.email) && name.equals(that.name) && password.equals(that.password) && Objects.equals(createdAt, that.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name, password, createdAt);
  }
}
