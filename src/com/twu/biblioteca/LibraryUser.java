package com.twu.biblioteca;

public class LibraryUser {

    private String name;
    private String email;
    private Integer phoneNumber;
    private String username;
    private String password;

    public LibraryUser(String name, String email, Integer phoneNumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
