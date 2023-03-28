package com.ocr.backend.service;

import com.ocr.backend.dto.MessageDTO;

public interface MessagesService {

  MessageDTO save(MessageDTO messageDTO);
}
