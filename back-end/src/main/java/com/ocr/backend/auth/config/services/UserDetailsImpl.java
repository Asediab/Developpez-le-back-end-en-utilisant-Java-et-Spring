package com.ocr.backend.auth.config.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String mail;

  private String name;
  //TODO check if needed property admin
  private Boolean admin;

  @JsonIgnore
  private String password;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  public UserDetailsImpl() {
  }

  public UserDetailsImpl(Long id, String mail, String name, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.mail = mail;
    this.name = name;
    this.password = password;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getId() {
    return id;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return new HashSet<GrantedAuthority>();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return mail;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UserDetailsImpl that)) return false;
    return id.equals(that.id) && mail.equals(that.mail) && name.equals(that.name) && admin.equals(that.admin) && password.equals(that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, mail, name, admin, password);
  }
}
