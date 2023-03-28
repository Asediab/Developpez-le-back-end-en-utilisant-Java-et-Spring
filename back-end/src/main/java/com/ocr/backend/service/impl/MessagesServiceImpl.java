package com.ocr.backend.service.impl;

import com.ocr.backend.dao.MessageDAO;
import com.ocr.backend.dto.MessageDTO;
import com.ocr.backend.model.Message;
import com.ocr.backend.service.MessagesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MessagesServiceImpl implements MessagesService {

  private final ModelMapper modelMapper = new ModelMapper();

  private final MessageDAO messageDAO;


  public MessagesServiceImpl(MessageDAO messageDAO) {
    this.messageDAO = messageDAO;
  }

  @Override
  public MessageDTO save(MessageDTO messageDTO) {
    messageDTO.setCreatedAt(LocalDate.now());
    return toDto(messageDAO.save(toEntity(messageDTO)));
  }

  private MessageDTO toDto(Message message) {
    MessageDTO dto = modelMapper.map(message, MessageDTO.class);
    dto.setRental_id(message.getRentalId());
    dto.setUser_id(message.getUserId());
    return dto;
  }

  private Message toEntity(MessageDTO messageDTO) {
    Message message = modelMapper.map(messageDTO, Message.class);
    message.setUserId(messageDTO.getUser_id());
    message.setRentalId(messageDTO.getRental_id());
    return message;
  }
}
