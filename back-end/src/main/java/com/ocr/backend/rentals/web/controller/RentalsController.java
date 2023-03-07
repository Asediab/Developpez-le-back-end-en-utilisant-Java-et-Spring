package com.ocr.backend.rentals.web.controller;


import com.ocr.backend.rentals.dto.RentalsDTO;
import com.ocr.backend.rentals.service.RentalsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RentalsController.class);

  @Autowired
  private RentalsService rentalsService;

  @GetMapping()
  public List<RentalsDTO> getAllRentals() {
    return rentalsService.getAllRentals();
  }

  @GetMapping("{id}")
  public RentalsDTO getRentalsById(@PathVariable("id") Long id) {
    return rentalsService.getRentalsById(id);
  }

  //TODO create method saveRentals
  @PostMapping()
  public ResponseEntity<Void> saveRentals() {
    return null;
  }

  //TODO create method modifyRentals
  @PutMapping("{id}")
  public ResponseEntity<Void> modifyRentals() {
    return null;
  }
}
