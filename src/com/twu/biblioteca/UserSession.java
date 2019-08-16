package com.twu.biblioteca;

public class UserSession {

   private Boolean sessionStarted;
   private String userName;

    public UserSession(String userName) {
        this.sessionStarted = true;
        this.userName = userName;
    }

    public UserSession() {
        this.sessionStarted = false;
    }

    public Boolean getSessionStarted() {
        return sessionStarted;
    }

    public String getUserName() {
        return userName;
    }

}
