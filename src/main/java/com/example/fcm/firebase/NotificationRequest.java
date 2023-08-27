package com.example.fcm.firebase;

import java.util.Map;

import lombok.Data;

@Data
public class NotificationRequest {

    private String recipientToken;
    private String title;
    private String body;
    private String image;
    private Map<String, String> data;

}
