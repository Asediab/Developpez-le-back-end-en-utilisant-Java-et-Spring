package com.ocr.backend.rentals.web.controller;


import com.ocr.backend.rentals.dto.RentalsDTO;
import com.ocr.backend.rentals.service.RentalsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Rentals", description = "The Rentals API. Contains all the operations that can be performed with a Rentals.")
public class RentalsController {

  @Autowired
  private RentalsService rentalsService;

  @Operation(summary = "Get all rentals")
  @GetMapping()
  public List<RentalsDTO> getAllRentals() {
    return rentalsService.getAllRentals();
  }

  @Operation(summary = "Get an Rentals by ID")
  @GetMapping("{id}")
  public RentalsDTO getRentalsById(@Parameter(description = "id of Rentals to be searched")
    @PathVariable("id") Long id) {
    return rentalsService.getRentalsById(id);
  }

  //TODO create method saveRentals
  @Operation(summary = "Save Rentals")
  @PostMapping()
  public ResponseEntity<Void> saveRentals() {
    return null;
  }

  //TODO create method modifyRentals
  @Operation(summary = "Modify Rentals by ID")
  @PutMapping("{id}")
  public ResponseEntity<Void> modifyRentals(@Parameter(description = "id of Rentals to be modified")
     @PathVariable("id") Long id) {
    return null;
  }
}
