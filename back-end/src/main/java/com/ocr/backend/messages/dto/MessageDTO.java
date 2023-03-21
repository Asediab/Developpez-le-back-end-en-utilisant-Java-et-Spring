package com.ocr.backend.messages.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MessageDTO implements Serializable {
  private Long id;

  private long rental_id;

  private long user_id;

  private String message;

  private LocalDate createdAt;

  private LocalDate updatedAt;

  public MessageDTO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getRental_id() {
    return rental_id;
  }

  public void setRental_id(long rental_id) {
    this.rental_id = rental_id;
  }

  public long getUser_id() {
    return user_id;
  }

  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "MessageDTO{" +
      "id=" + id +
      ", rentalId=" + rental_id +
      ", userId=" + user_id +
      ", message='" + message + '\'' +
      ", createdAt=" + createdAt +
      ", updatedAt=" + updatedAt +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MessageDTO that)) return false;
    return rental_id == that.rental_id &&
      user_id == that.user_id &&
      id.equals(that.id) &&
      message.equals(that.message) &&
      createdAt.equals(that.createdAt) &&
      updatedAt.equals(that.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, rental_id, user_id, message, createdAt, updatedAt);
  }
}
