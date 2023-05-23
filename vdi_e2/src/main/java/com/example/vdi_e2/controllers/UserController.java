package com.example.vdi_e2.controllers;

import com.example.vdi_e2.entities.User;
import com.example.vdi_e2.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/user")
  // @PreAuthorize("#user.username = authentication.name")
  // @PostAuthorize
  // @PreFilter
  // @PostFilter
  public void addUser(@RequestBody User user) {
    userService.addUser(user);
  }
}
