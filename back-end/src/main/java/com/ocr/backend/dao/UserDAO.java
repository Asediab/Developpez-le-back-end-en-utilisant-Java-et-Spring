package com.ocr.backend.dao;

import com.ocr.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

  @Transactional
  Optional<User> findByEmail(String email);
  Boolean existsByEmail(String email);
}
