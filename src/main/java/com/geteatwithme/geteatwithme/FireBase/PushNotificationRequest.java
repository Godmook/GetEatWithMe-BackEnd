package com.geteatwithme.geteatwithme.FireBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PushNotificationRequest {


    private String title;
    private String message;

    public void setTopic(String topic) {
        this.topic = topic;
    }

    private String topic;
    private String token;
    private String click_action;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClick_action() {
        return click_action;
    }

    public void setClick_action(String click_action) {
        this.click_action = click_action;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getTopic() {
        return topic;
    }

    public String getToken() {
        return token;
    }
}