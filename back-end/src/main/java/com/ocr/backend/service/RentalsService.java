package com.ocr.backend.service;

import com.ocr.backend.payload.RentalsResponses;
import com.ocr.backend.dto.RentalsDTO;
import com.ocr.backend.payload.RentalsResponse;

public interface RentalsService {

  RentalsResponses getAllRentals();
  RentalsResponse getRentalsById(Long rentalsId);
  RentalsDTO saveRentals(RentalsDTO rentalsDTO, String picture);
  RentalsResponse updateRentals(RentalsResponse rentals, long id);
}
