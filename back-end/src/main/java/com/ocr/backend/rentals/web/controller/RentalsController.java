package com.ocr.backend.rentals.web.controller;


import com.ocr.backend.payload.MessageResponse;
import com.ocr.backend.payload.RentalsResponses;
import com.ocr.backend.rentals.dto.RentalsDTO;
import com.ocr.backend.rentals.dto.RentalsResponse;
import com.ocr.backend.rentals.service.FileUploadService;
import com.ocr.backend.rentals.service.RentalsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("api/rentals")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Rentals", description = "The Rentals API. Contains all the operations that can be performed with a Rentals.")
public class RentalsController {

  @Autowired
  private RentalsService rentalsService;

  @Autowired
  private FileUploadService fileUploadService;

  @Operation(summary = "Get all rentals")
  @GetMapping()
  public ResponseEntity<RentalsResponses> getAllRentals() {
    return ResponseEntity.ok(rentalsService.getAllRentals());
  }

  @Operation(summary = "Get an Rentals by ID")
  @GetMapping("{id}")
  public RentalsResponse getRentalsById(@Parameter(description = "id of Rentals to be searched")
    @PathVariable("id") Long id) {
    return rentalsService.getRentalsById(id);
  }

  @Operation(summary = "Save Rentals")
  @PostMapping()
  public ResponseEntity<?> saveRentals(@ModelAttribute("rentals") RentalsDTO rentalsDTO) throws IOException {
    String pictureUrl = fileUploadService.saveFile(rentalsDTO.getPicture());
    RentalsDTO rentalsDTO1 = rentalsService.saveRentals(rentalsDTO, pictureUrl);
    if(rentalsDTO1 != null) {
      return ResponseEntity.ok(new MessageResponse("Rental created !"));
    }
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @Operation(summary = "Modify Rentals by ID")
  @PutMapping("{id}")
  public ResponseEntity<?> modifyRentals(@Parameter(description = "id of Rentals to be modified")
                                              @PathVariable("id") Long id,
                                            @ModelAttribute("rentals") RentalsResponse rentalsResponse) {
    RentalsResponse response = rentalsService.updateRentals(rentalsResponse, id);
    if(response != null) {
      return ResponseEntity.ok(new MessageResponse("Rental updated !"));
    }
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
