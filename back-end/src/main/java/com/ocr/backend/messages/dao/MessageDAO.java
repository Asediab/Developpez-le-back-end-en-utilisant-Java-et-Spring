package com.ocr.backend.messages.dao;

import com.ocr.backend.messages.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDAO extends JpaRepository<Message, Long> {
}
