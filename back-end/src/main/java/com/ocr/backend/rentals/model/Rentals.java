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
}
