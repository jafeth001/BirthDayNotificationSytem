package com.IZSoftware.Birthday.Notification.dto;



public class UserAuthenticateResponse {
    private String token;
    private String message;
    public UserAuthenticateResponse() {
    }
    public UserAuthenticateResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
