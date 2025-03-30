package com.example.demo.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseToken {
    private String userId;
    private String token;
    private String etmsToken;
    private String etmsId;

}
