package com.twu.biblioteca;

import java.util.ArrayList;

public class UserManager {

    private ArrayList<LibraryUser> listOfUsers;

    public UserManager() {
        this.listOfUsers = createListOfUsers();
    }

    public ArrayList<LibraryUser> getListOfUsers() {
        return listOfUsers;
    }

    public ArrayList<LibraryUser> createListOfUsers() {
        ArrayList<LibraryUser> listOfUsers = new ArrayList<LibraryUser>();
        listOfUsers.add(new LibraryUser("Rosa", "rosa.palli@thoughtworks.com", 936687826, "rosapalli", "abc12345"));
        return listOfUsers;
    }

    public Boolean userAuthentication(String username, String password) {
        Boolean match = false;
        for (LibraryUser user : listOfUsers) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                match = true;
                break;
            }
        }
        return match;
    }

    public UserSession startSession(String username) {
        UserSession userSession = new UserSession(username);
        return userSession;
    }

    public LibraryUser findUserInformation(String username) {
        LibraryUser currentUser = null;
        for (LibraryUser user: getListOfUsers()) {
            if(user.getUsername().equals(username)) {
                return currentUser = user;
            }
        }
        return currentUser;
    }

    public UserSession loginUser(String username, String password) {
        UserSession userSession = new UserSession();
        Boolean validUser = userAuthentication(username, password);
        if (validUser) {
            userSession = startSession(username);
            System.out.println("Session started successfully for " + username);
            return userSession;
        } else {
            System.out.println("Wrong credentials.Please try again.");
        }
        return userSession;
    }


}

