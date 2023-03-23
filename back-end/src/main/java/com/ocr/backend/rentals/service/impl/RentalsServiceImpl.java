package com.ocr.backend.rentals.service.impl;

import com.ocr.backend.auth.dao.UserDAO;
import com.ocr.backend.auth.model.User;
import com.ocr.backend.payload.RentalsResponses;
import com.ocr.backend.rentals.dao.RentalsDAO;
import com.ocr.backend.rentals.dto.RentalsDTO;
import com.ocr.backend.rentals.dto.RentalsMapper;
import com.ocr.backend.rentals.dto.RentalsResponse;
import com.ocr.backend.rentals.model.Rentals;
import com.ocr.backend.rentals.service.RentalsService;
import com.ocr.backend.exeption.NotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalsServiceImpl implements RentalsService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RentalsServiceImpl.class);
  private final ModelMapper modelMapper = new ModelMapper();

  private final RentalsDAO rentalsDAO;

  private final UserDAO userDAO;

  private final RentalsMapper mapper;

  public RentalsServiceImpl(RentalsDAO rentalsDAO, UserDAO userDAO, RentalsMapper mapper) {
    this.rentalsDAO = rentalsDAO;
    this.userDAO = userDAO;
    this.mapper = mapper;
  }

  @Override
  public RentalsResponses getAllRentals() {
    RentalsResponses rentalsResponses = new RentalsResponses(new ArrayList<>());
    ArrayList<RentalsResponse> responseList = new ArrayList<>();
    List<Rentals> entityList = rentalsDAO.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "id"));
    for (Rentals rentals : entityList) {
      responseList.add(mapper.toResponse(rentals));
    }
    if (!responseList.isEmpty()) {
      rentalsResponses.setRentals(responseList);
      return rentalsResponses;
    } else {
      LOGGER.error("Data base is empty");
      throw new NotFoundException("Data base is empty");
    }
  }

  @Override
  public RentalsResponse getRentalsById(Long rentalsId) {
    Rentals rentals = rentalsDAO.findById(rentalsId).orElseThrow(() -> new NotFoundException("Rental with this Id not found"));
    return mapper.toResponse(rentals);
  }

  @Override
  public RentalsDTO saveRentals(RentalsDTO rentalsDTO, String picture) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Rentals rentals = toEntity(rentalsDTO);
    rentals.setPicture(picture);
    rentals.setCreatedAt(LocalDate.now());

    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      String currentUserName = authentication.getName();
      User user = userDAO.findByEmail(currentUserName).orElseThrow(() -> new NotFoundException("User with this Mail not found"));
      rentals.setOwnerId(user.getId());
    }

    LOGGER.info("Rentals saved");
    return toDto(rentalsDAO.save(rentals));
  }


  @Override
  public RentalsResponse updateRentals(RentalsResponse rentals, long id) {
    Rentals rental = rentalsDAO.findById(id).orElseThrow(() -> new NotFoundException("Rental with this Id not found"));
    if (rental != null) {
      rental.setName(rentals.getName());
      rental.setSurface(rentals.getSurface());
      rental.setPrice(rentals.getPrice());
      rental.setDescription(rentals.getDescription());
      rental.setUpdatedAT(LocalDate.now());
      rentalsDAO.save(rental);
      return mapper.toResponse(rental);
    }
    return null;
  }

  private RentalsDTO toDto(Rentals rentals) {
    return modelMapper.map(rentals, RentalsDTO.class);
  }

  private Rentals toEntity(RentalsDTO rentalsDTO) {
    return modelMapper.map(rentalsDTO, Rentals.class);
  }


}
