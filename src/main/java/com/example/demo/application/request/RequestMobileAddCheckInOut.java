package com.example.demo.application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMobileAddCheckInOut {
    private Header header;
    private BodyData bodyData;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Header {
        private String authorization = "Basic c3NkX2FwaTpzc2RAMjAxNw==";
        private String userName;
        private String token;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BodyData {
        private String userId;
        private String typeCheckInOut;
        private String dateCheckInOut;
    }
}
