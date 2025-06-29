package com.example.demo.application.controller;

import com.example.demo.application.request.RequestLogin;
import com.example.demo.application.request.RequestMobileAddCheckInOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {


  private static final String LOGIN_API_URL = "https://ddc.fis.vn/fis0/api/login";
  private static final String MobileAddCheckInOut = "https://ddc.fis.vn/apietms/api/ChechInData/MobileAddCheckInOut";
  private static final String TOKEN_API_URL = "https://googleads.g.doubleclick.net/pagead/id";

  private final RestTemplate restTemplate;

  @GetMapping("/get-token")
  public ResponseEntity<Object> getToken() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RequestLogin requestLogin = new RequestLogin();
    requestLogin.setUsername("baodt7");
    requestLogin.setPassword("Dungtrinh@99112233");

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

  @PostMapping("/MobileAddCheckInOut")
  public ResponseEntity<Object> mobileAddCheckInOut(@RequestBody RequestMobileAddCheckInOut requestMobileAddCheckInOut) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization" , requestMobileAddCheckInOut.getHeader().getAuthorization());
    headers.set("username" , requestMobileAddCheckInOut.getHeader().getUserName());
    headers.set("token" , requestMobileAddCheckInOut.getHeader().getToken());

    String userId = requestMobileAddCheckInOut.getBodyData().getUserId();
    String typeCheckInOut = requestMobileAddCheckInOut.getBodyData().getTypeCheckInOut();
    String dateCheckInOut = requestMobileAddCheckInOut.getBodyData().getDateCheckInOut();
    HttpEntity<Object> request = new HttpEntity<>(null, headers);

    try {
      ResponseEntity<Object> response = restTemplate.exchange(
              MobileAddCheckInOut +"?" +"userId="+userId + "&typeCheckInOut=" +typeCheckInOut +"&dateCheckInOut="+dateCheckInOut,
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
}
