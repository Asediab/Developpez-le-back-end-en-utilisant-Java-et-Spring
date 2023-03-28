package com.ocr.backend.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class RentalsDTO implements Serializable {

  private Long id;
  private String name;
  private int surface;
  private int price;
  private MultipartFile picture;
  private String description;
  private long ownerId;
  private LocalDate createdAt;
  private LocalDate updatedAT;

  public RentalsDTO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MultipartFile getPicture() {
    return picture;
  }

  public void setPicture(MultipartFile picture) {
    this.picture = picture;
  }

  public int getSurface() {
    return surface;
  }

  public void setSurface(int surface) {
    this.surface = surface;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(long ownerId) {
    this.ownerId = ownerId;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getUpdatedAT() {
    return updatedAT;
  }

  public void setUpdatedAT(LocalDate updatedAT) {
    this.updatedAT = updatedAT;
  }

  @Override
  public String toString() {
    return "RentalsDTO{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", surface=" + surface +
      ", price=" + price +
      ", picture=" + picture +
      ", description='" + description + '\'' +
      ", ownerId=" + ownerId +
      ", createdAt=" + createdAt +
      ", updatedAT=" + updatedAT +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RentalsDTO that)) return false;
    return surface == that.surface && price == that.price && ownerId == that.ownerId && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(picture, that.picture) && Objects.equals(description, that.description) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAT, that.updatedAT);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surface, price, picture, description, ownerId, createdAt, updatedAT);
  }
}
