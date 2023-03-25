package com.ocr.backend.rentals.model;

import com.ocr.backend.messages.model.Message;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "RENTALS")
public class Rentals implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name",nullable = false)
  private String name;

  @Column(name = "surface",nullable = false)
  private int surface;

  @Column(name = "price",nullable = false)
  private int price;

  @Column(name = "picture",nullable = false)
  private String picture;

  @Column(name = "description",nullable = false, length = 2000)
  private String description;

  @Column(name = "owner_id",nullable = false)
  private long ownerId;

  @Column(name = "created_at",nullable = false)
  private LocalDate createdAt;

  @Column(name = "updated_at")
  private LocalDate updatedAT;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  @JoinColumn(name = "rental_id")
  private List<Message> messages = new ArrayList<>();

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

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
}
