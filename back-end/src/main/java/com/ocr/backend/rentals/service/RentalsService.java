package com.ocr.backend.rentals.service;

import com.ocr.backend.rentals.dto.RentalsDTO;

import java.util.List;

public interface RentalsService {

  List<RentalsDTO> getAllRentals();
  RentalsDTO getRentalsById(Long rentalsId);
  RentalsDTO saveRentals(RentalsDTO rentalsDTO, String picture);
}
