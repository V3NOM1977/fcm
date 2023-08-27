package com.example.fcm.firebase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/fcm")
public class FcmController {

    private final FcmService firebaseService;

    @GetMapping
    public String helloWrld() {
        return "Hello World...!!";
    }

    @PostMapping(path = "send_notification")
    public String sendNotification(@RequestBody NotificationRequest notificationRequest) {
        return firebaseService.sendNotificationByToken(notificationRequest);
    }

}
