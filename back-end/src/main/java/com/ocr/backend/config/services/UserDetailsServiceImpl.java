package com.ocr.backend.config.services;

import com.ocr.backend.dao.UserDAO;
import com.ocr.backend.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  UserDAO userDAO;

  public UserDetailsServiceImpl(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
    User user = userDAO.findByEmail(mail)
      .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + mail));

    return new UserDetailsImpl(
      user.getId(),
      user.getEmail(),
      user.getName(),
      user.getPassword(),
      user.getCreatedAt(),
      user.getUpdatedAt());
  }
}
