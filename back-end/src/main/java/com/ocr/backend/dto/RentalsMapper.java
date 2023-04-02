package com.ocr.backend.dto;

import com.ocr.backend.model.Rentals;
import com.ocr.backend.payload.RentalsResponse;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RentalsMapper {
  private final ModelMapper modelMapper;
  private final Converter<String, String> isbnRemover = src -> src.getSource().replaceAll("ISBN: ", "");

public RentalsMapper() {
  this.modelMapper = new ModelMapper();
  this.modelMapper.createTypeMap(Rentals.class, RentalsResponse.class)
    .addMapping(Rentals::getOwnerId, RentalsResponse::setOwner_id)
    .addMapping(Rentals::getCreatedAt, RentalsResponse::setCreated_at)
    .addMapping(Rentals::getUpdatedAT, RentalsResponse::setUpdated_at);
}



  public RentalsDTO convertToDto(Rentals entity) {
    return modelMapper.map(entity, RentalsDTO.class);
  }

  public RentalsResponse toResponse(Rentals rentals) {

    RentalsResponse response = this.modelMapper.map(rentals, RentalsResponse.class);
    response.setPicture(rentals.getPicture());
    return response;
  }
}
