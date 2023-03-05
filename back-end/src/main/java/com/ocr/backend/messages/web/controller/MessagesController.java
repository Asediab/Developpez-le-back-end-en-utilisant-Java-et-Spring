package com.ocr.backend.messages.web.controller;

import com.ocr.backend.messages.dto.MessageDTO;
import com.ocr.backend.messages.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/messages")
public class MessagesController {

  @Autowired
  private MessagesService service;

  @PostMapping
  public ResponseEntity<Void> saveMessage(@RequestBody MessageDTO messageDTO) {
  MessageDTO message = service.save(messageDTO);
  if (message != null) {
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
