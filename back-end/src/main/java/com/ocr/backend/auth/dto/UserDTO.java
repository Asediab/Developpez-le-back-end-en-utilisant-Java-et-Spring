package com.ocr.backend.auth.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserDTO implements Serializable {
  private Long id;

  private String email;

  private String name;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  public UserDTO() {
  }

  public UserDTO(Long id, String email, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "UserDTO{" +
      "id=" + id +
      ", email='" + email + '\'' +
      ", name='" + name + '\'' +
      ", createdAt=" + createdAt +
      ", updatedAt=" + updatedAt +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UserDTO userDTO)) return false;
    return id.equals(userDTO.id) && email.equals(userDTO.email) && name.equals(userDTO.name) && createdAt.equals(userDTO.createdAt) && Objects.equals(updatedAt, userDTO.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, name, createdAt, updatedAt);
  }
}
