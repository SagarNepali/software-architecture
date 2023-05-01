package com.example.SeviceC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceCController {

  @GetMapping("/salary")
  public String getName() {
    return "4501.56";
  }
}

