package com.ocr.backend.rentals.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class RentalsResponse implements Serializable {

  private Long id;
  private String name;
  private int surface;
  private int price;
  private String picture;
  private String description;
  private long owner_id;
  private LocalDate created_at;
  private LocalDate update_at;

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

  public long getOwner_id() {
    return owner_id;
  }

  public void setOwner_id(long owner_id) {
    this.owner_id = owner_id;
  }

  public LocalDate getCreated_at() {
    return created_at;
  }

  public void setCreated_at(LocalDate created_at) {
    this.created_at = created_at;
  }

  public LocalDate getUpdate_at() {
    return update_at;
  }

  public void setUpdate_at(LocalDate update_at) {
    this.update_at = update_at;
  }



  @Override
  public String toString() {
    return "RentalsResponse{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", surface=" + surface +
      ", price=" + price +
      ", picture='" + picture + '\'' +
      ", description='" + description + '\'' +
      ", owner_id=" + owner_id +
      ", created_at=" + created_at +
      ", update_at=" + update_at +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RentalsResponse that)) return false;
    return surface == that.surface && price == that.price && owner_id == that.owner_id && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(picture, that.picture) && Objects.equals(description, that.description) && Objects.equals(created_at, that.created_at) && Objects.equals(update_at, that.update_at);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surface, price, picture, description, owner_id, created_at, update_at);
  }
}
