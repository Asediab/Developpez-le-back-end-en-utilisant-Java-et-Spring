package com.ocr.backend.rentals.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class RentalsResponse implements Serializable {

  private Long id;
  private String name;
  private int surface;
  private int price;
  private String picture;
  private String description;
  private long ownerId;
  private Date createdAt;
  private Date updatedAT;

  public RentalsResponse() {
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

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAT() {
    return updatedAT;
  }

  public void setUpdatedAT(Date updatedAT) {
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
    if (!(o instanceof RentalsResponse that)) return false;
    return surface == that.surface && price == that.price && ownerId == that.ownerId && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(picture, that.picture) && Objects.equals(description, that.description) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAT, that.updatedAT);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surface, price, picture, description, ownerId, createdAt, updatedAT);
  }
}
