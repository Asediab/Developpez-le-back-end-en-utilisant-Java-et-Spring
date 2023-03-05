package com.ocr.backend.messages.service;

import com.ocr.backend.messages.dto.MessageDTO;

public interface MessagesService {

  MessageDTO save(MessageDTO messageDTO);
}
