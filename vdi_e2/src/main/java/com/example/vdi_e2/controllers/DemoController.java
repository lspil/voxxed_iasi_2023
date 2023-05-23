package com.example.vdi_e2.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping("/demo")
  public String demo() {
    return "Demo";
  }

  @GetMapping("/user")
  public Authentication userDetails() {
    var a =
        SecurityContextHolder.getContext().getAuthentication();
    return a;
  }
}
