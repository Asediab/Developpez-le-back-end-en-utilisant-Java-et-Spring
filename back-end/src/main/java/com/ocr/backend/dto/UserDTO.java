package com.ocr.backend.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserDTO implements Serializable {
  private Long id;

  private String email;

  private String name;

  private LocalDate created_at;

  private LocalDate updated_at;

  public UserDTO() {
  }

  public UserDTO(Long id, String email, String name, LocalDate createdAt, LocalDate updatedAt) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.created_at = createdAt;
    this.updated_at = updatedAt;
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

  public LocalDate getCreated_at() {
    return created_at;
  }

  public void setCreated_at(LocalDate created_at) {
    this.created_at = created_at;
  }

  public LocalDate getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(LocalDate updated_at) {
    this.updated_at = updated_at;
  }

  @Override
  public String toString() {
    return "UserDTO{" +
      "id=" + id +
      ", email='" + email + '\'' +
      ", name='" + name + '\'' +
      ", created_at=" + created_at +
      ", updated_at=" + updated_at +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UserDTO userDTO)) return false;
    return id.equals(userDTO.id) && email.equals(userDTO.email) && name.equals(userDTO.name) && created_at.equals(userDTO.created_at) && Objects.equals(updated_at, userDTO.updated_at);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, name, created_at, updated_at);
  }
}
