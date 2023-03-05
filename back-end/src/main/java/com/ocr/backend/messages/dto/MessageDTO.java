package com.ocr.backend.messages.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class MessageDTO implements Serializable {
  private Long id;

  private long rentalId;

  private long userId;

  private String message;

  private Date createdAt;

  private Date updatedAt;

  public MessageDTO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getRentalId() {
    return rentalId;
  }

  public void setRentalId(long rentalId) {
    this.rentalId = rentalId;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "MessageDTO{" +
      "id=" + id +
      ", rentalId=" + rentalId +
      ", userId=" + userId +
      ", message='" + message + '\'' +
      ", createdAt=" + createdAt +
      ", updatedAt=" + updatedAt +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MessageDTO that)) return false;
    return rentalId == that.rentalId &&
      userId == that.userId &&
      id.equals(that.id) &&
      message.equals(that.message) &&
      createdAt.equals(that.createdAt) &&
      updatedAt.equals(that.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, rentalId, userId, message, createdAt, updatedAt);
  }
}
