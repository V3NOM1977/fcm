package com.example.fcm.firebase;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FcmService {

    private final FirebaseMessaging firebaseMessaging;

    public String sendNotificationByToken(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .setTitle(notificationRequest.getTitle())
                .setBody(notificationRequest.getBody())
                .setImage(notificationRequest.getImage())
                .build();
        Message msg = Message.builder()
                .setNotification(notification)
                .putAllData(notificationRequest.getData())
                .setToken(notificationRequest.getRecipientToken())
                .build();
        try {
            firebaseMessaging.send(msg);
            return "Notification sent successfully";
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
            return "Notification sent failed";
        }
    }

}
