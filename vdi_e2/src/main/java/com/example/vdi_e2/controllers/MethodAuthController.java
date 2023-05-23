package com.example.vdi_e2.controllers;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodAuthController {

  @PostAuthorize("returnObject == @customAuhtorizationManager.meSmthToCompare")  // if username is what method returns
  public String method1() {
    return "bill";
  }
}
