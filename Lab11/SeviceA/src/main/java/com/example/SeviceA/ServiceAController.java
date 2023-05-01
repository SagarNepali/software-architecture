package com.example.SeviceA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {

  @Autowired
  OAuth2RestTemplate restTemplate;

  @GetMapping("/salary")
  public String getName() {
    return restTemplate.getForObject("http://localhost:8090/salary", String.class);
  }

  @GetMapping("/phone")
  public String getPhone() {
    return restTemplate.getForObject("http://localhost:8091/phone", String.class);
  }

  @GetMapping("/product")
  public String getProduct() {
    return "Product : Huwaeri";
  }


}

