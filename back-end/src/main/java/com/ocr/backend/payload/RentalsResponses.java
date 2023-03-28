package com.ocr.backend.payload;

import java.util.ArrayList;

public class RentalsResponses {

  private ArrayList<RentalsResponse> rentals;

  public RentalsResponses(ArrayList<RentalsResponse> rentals) {
    this.rentals = rentals;
  }

  public ArrayList<RentalsResponse> getRentals() {
    return rentals;
  }

  public void setRentals(ArrayList<RentalsResponse> rentalsDTOS) {
    this.rentals = rentalsDTOS;
  }
}
