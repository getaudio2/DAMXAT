package com.example.damxat;

import com.google.gson.annotations.SerializedName;

public class PushNotification {

    @SerializedName("to")
    private String to;

    @SerializedName("notification")
    private NotificationModel notification;

    public PushNotification(String to, NotificationModel notification) {
        this.to = to;
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public NotificationModel getNotification() {
        return notification;
    }

    public void setNotification(NotificationModel notification) {
        this.notification = notification;
    }
}
