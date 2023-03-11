package com.ocr.backend.rentals.dao;

import com.ocr.backend.rentals.model.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsDAO extends JpaRepository<Rentals, Long> {
}
