package com.twu.biblioteca;

import java.util.ArrayList;

public interface LibraryManager {

        public void createListOfItems();

        public ArrayList<? extends LibraryItem> checkoutItem(String itemName, String username);

        public ArrayList<? extends LibraryItem> returnItem(String itemName);

}
