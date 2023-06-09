package com.ocr.backend.auth.dto;

import com.ocr.backend.auth.model.User;
import com.ocr.backend.payload.SingupRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  private final ModelMapper modelMapper;

  public UserMapper() {
    this.modelMapper = new ModelMapper();
    TypeMap<User, UserDTO> propertyMapper = this.modelMapper.createTypeMap(User.class, UserDTO.class);
    propertyMapper.addMapping(User::getUpdatedAt, UserDTO::setUpdated_at)
      .addMapping(User::getCreatedAt, UserDTO::setCreated_at);
  }

  public UserDTO toDto(User userToDto) {

    UserDTO userDTO = modelMapper.map(userToDto, UserDTO.class);

    return userDTO;
  }

  public User toEntity(SingupRequest singupRequestToEntity) {
    return modelMapper.map(singupRequestToEntity, User.class);
  }
}
