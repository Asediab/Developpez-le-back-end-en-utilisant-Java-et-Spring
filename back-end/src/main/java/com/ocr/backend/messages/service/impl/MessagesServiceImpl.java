package com.ocr.backend.messages.service.impl;

import com.ocr.backend.messages.dao.MessageDAO;
import com.ocr.backend.messages.dto.MessageDTO;
import com.ocr.backend.messages.model.Message;
import com.ocr.backend.messages.service.MessagesService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessagesServiceImpl implements MessagesService {

  private static final Logger LOGGER = LoggerFactory.getLogger(MessagesServiceImpl.class);
  private final ModelMapper modelMapper = new ModelMapper();

  private final MessageDAO messageDAO;


  public MessagesServiceImpl(MessageDAO messageDAO) {
    this.messageDAO = messageDAO;
  }

  @Override
  public MessageDTO save(MessageDTO messageDTO) {
    LOGGER.info("Message saved");
    return toDto(messageDAO.save(toEntity(messageDTO)));
  }

  private MessageDTO toDto(Message message) {
    return modelMapper.map(message, MessageDTO.class);
  }

  private Message toEntity(MessageDTO messageDTO) {
    return modelMapper.map(messageDTO, Message.class);
  }
}
