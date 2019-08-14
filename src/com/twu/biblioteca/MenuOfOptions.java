package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuOfOptions {

    ArrayList<String> options;

    public void populateMenuOfOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("type 'list' for - List of Books");
        options.add("type 'checkout' for - Check out a book");
        options.add("type 'return' for - Return a book");
        options.add("type 'exit' to Exit the application");
        this.options = options;
    }


}
