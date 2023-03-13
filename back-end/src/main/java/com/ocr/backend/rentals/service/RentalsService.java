package com.ocr.backend.rentals.service;

import com.ocr.backend.rentals.dto.RentalsDTO;
import com.ocr.backend.rentals.dto.RentalsResponse;

import java.util.List;

public interface RentalsService {

  List<RentalsResponse> getAllRentals();
  RentalsResponse getRentalsById(Long rentalsId);
  RentalsDTO saveRentals(RentalsDTO rentalsDTO, String picture);
  RentalsResponse updateRentals(RentalsResponse rentals, long id);
}
