package com.example.demo.application.controller;

import com.example.demo.application.request.RequestLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {


  private static final String LOGIN_API_URL = "https://ddc.fis.vn/fis0/api/login";
  private static final String TOKEN_API_URL = "https://googleads.g.doubleclick.net/pagead/id";

  private final RestTemplate restTemplate;

  @GetMapping("/get-token")
  public ResponseEntity<Object> getToken() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RequestLogin requestLogin = new RequestLogin();
    requestLogin.setUsername("baodt7");
    requestLogin.setPassword("Dungtrinh@123123123");

    System.out.println("tesst");

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

  @GetMapping("/gen-api")
  public ResponseEntity<String> reload() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<Void> request = new HttpEntity<>(headers);

    try {
      ResponseEntity<String> response = restTemplate.exchange(
              TOKEN_API_URL,
              HttpMethod.GET,
              request,
              String.class
      );
      return response;
    } catch (Exception e) {
      // Handle errors appropriately
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body(null);
    }
  }
}
