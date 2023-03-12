package com.ocr.backend.messages.web.controller;

import com.ocr.backend.messages.dto.MessageDTO;
import com.ocr.backend.messages.service.MessagesService;
import com.ocr.backend.payload.MessageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test/messages")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Message", description = "The Message API. Contains all the operations that can be performed with a Message.")
public class MessagesController {
  private final MessagesService service;

  public MessagesController(MessagesService service) {
    this.service = service;
  }

  @Operation(summary = "Save Message")
  @PostMapping
  public ResponseEntity<?> saveMessage(@RequestBody MessageDTO messageDTO) {
  MessageDTO message = service.save(messageDTO);
  if (message != null) {
    return ResponseEntity.ok(new MessageResponse("Message send with success"));
  }
  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
