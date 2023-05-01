package com.example.SeviceB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

  @GetMapping("/phone")
  public String getName() {
    return "641855986";
  }
}

