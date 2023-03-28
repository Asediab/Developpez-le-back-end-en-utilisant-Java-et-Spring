package com.ocr.backend.dao;

import com.ocr.backend.model.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsDAO extends JpaRepository<Rentals, Long> {
}
