package com.example.demo.application.controller;

import com.example.demo.application.request.RequestLogin;
import com.example.demo.application.response.ResponseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {


  private static final String LOGIN_API_URL = "https://ddc.fis.vn/fis0/api/login";

  private final RestTemplate restTemplate;

  @GetMapping("/get-token")
  public ResponseEntity<Object> getToken() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RequestLogin requestLogin = new RequestLogin();
    requestLogin.setUsername("baodt7");
    requestLogin.setPassword("Dungtrinh@123123123");

    HttpEntity<RequestLogin> request = new HttpEntity<>(requestLogin, headers);

    try {
      ResponseEntity<Object> response = restTemplate.exchange(
              LOGIN_API_URL,
              HttpMethod.POST,
              request,
              Object.class
      );
      return response;
    } catch (Exception e) {
      // Handle errors appropriately
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body(new HashMap<>());
    }
  }

  @GetMapping("/reload")
  public ResponseEntity<Integer> reload() {
    return ResponseEntity.ok().body(null);
  }
}
