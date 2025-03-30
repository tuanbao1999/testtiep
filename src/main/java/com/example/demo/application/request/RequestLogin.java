package com.example.demo.application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLogin {
    private String username;
    private String password;
    private String loginDevice ="3356e246-5cb4-4585-a575-b17593858e2a";
    private String buildNumber ="15";
    private String version ="1.69.10885";
    private String deviceIP ="10.15.180.57";
    private String deviceModel ="IPhone XSMAX";
    private String osVersion = "15";
}
