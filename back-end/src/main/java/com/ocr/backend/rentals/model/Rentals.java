package com.ocr.backend.rentals.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Rentals implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private int surface;

  @Column(nullable = false)
  private int price;

  @Column(nullable = false)
  private String picture;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private long ownerId;

  @Column(nullable = false)
  private Date createdAt;

  @Column(nullable = false)
  private Date updatedAT;

  public Rentals() {
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

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
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
}
