package com.example.demo.application.schedule;

import com.example.demo.application.request.RequestLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class Schedule {
    private static final String LOGIN_API_URL = "https://testtiep.onrender.com/api/admin/reload";
    private final RestTemplate restTemplate;

    // Chạy mỗi 30 giây
    @Scheduled(fixedRate = 600000)
    public void scheduleFixedRateTask() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>("", headers);
        ResponseEntity<Object> response = restTemplate.exchange(
                LOGIN_API_URL,
                HttpMethod.GET,
                request,
                Object.class
        );
    }
}
