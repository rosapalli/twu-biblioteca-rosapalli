package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuOfOptions {

    ArrayList<String> options;

    public MenuOfOptions() {
        populateMenuOfOptions();
    }

    public void populateMenuOfOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("type 'books' for - List of Books");
        options.add("type 'movies' for List of Movies");
        options.add("type 'checkout' for - Check out a book or a movie");
        options.add("type 'return' for - Return a book or a movie");
        options.add("type 'login' to start a session");
        options.add("type 'details' to see your user information");
        options.add("type 'my loans' to see your checked out items");
        options.add("type 'exit' to Exit the application");
        this.options = options;
    }


}
