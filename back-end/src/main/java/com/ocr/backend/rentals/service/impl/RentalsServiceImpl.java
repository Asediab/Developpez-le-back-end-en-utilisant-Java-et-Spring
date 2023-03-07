package com.ocr.backend.rentals.service.impl;

import com.ocr.backend.rentals.dao.RentalsDAO;
import com.ocr.backend.rentals.dto.RentalsDTO;
import com.ocr.backend.rentals.model.Rentals;
import com.ocr.backend.rentals.service.RentalsService;
import com.ocr.backend.rentals.web.exeption.NotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalsServiceImpl implements RentalsService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RentalsServiceImpl.class);
  private final ModelMapper modelMapper = new ModelMapper();

  private final RentalsDAO rentalsDAO;

  public RentalsServiceImpl(RentalsDAO rentalsDAO) {
    this.rentalsDAO = rentalsDAO;
  }

  @Override
  public List<RentalsDTO> getAllRentals() {
    List<RentalsDTO> dtos = new ArrayList<>();
    List<Rentals> entityList = rentalsDAO.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "id"));
    for (Rentals rentals : entityList) {
      dtos.add(toDto(rentals));
    }
    if (!dtos.isEmpty()) {
      return dtos;
    } else {
      LOGGER.error("Data base is empty");
      throw new NotFoundException("Data base is empty");
    }
  }

  @Override
  public RentalsDTO getRentalsById(Long rentalsId) {
    Rentals rentals = rentalsDAO.findById(rentalsId).orElseThrow(() -> new NotFoundException("Rental with this Id not found"));
    return toDto(rentals);
  }

  @Override
  public RentalsDTO saveRentals(RentalsDTO rentalsDTO) {
    LOGGER.info("Rentals saved");
    return toDto(rentalsDAO.save(toEntity(rentalsDTO)));
  }

  private RentalsDTO toDto(Rentals rentals) {
    return modelMapper.map(rentals, RentalsDTO.class);
  }

  private Rentals toEntity(RentalsDTO rentalsDTO) {
    return modelMapper.map(rentalsDTO, Rentals.class);
  }
}
