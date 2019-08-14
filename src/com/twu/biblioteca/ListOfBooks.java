package com.twu.biblioteca;

import java.util.ArrayList;

public class ListOfBooks {

    private ArrayList<Book> listOfBooks;


    public void createArrayListOfBooks() {
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("1984", "George Orwell", 1948));
        list.add(new Book("The Brothers Karamazov", "Fiodor Dostoyevski", 1880));
        list.add(new Book("Catch-22", "Joseph Heller", 1953));
        this.listOfBooks = list;
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    public ArrayList<Book> checkoutBook(String userInput) {
        Boolean match = false;

        for(Book book : getListOfBooks() ) {
            if (book.getName().toLowerCase().contains(userInput)) {
               book.setIsAvailable(false);
               match = true;
                System.out.println("Thank you! Enjoy the book");
                break;
            }
        }
        if (!match) {
            System.out.println("Sorry, that book is not available");
        }
        return listOfBooks;
    }

    public ArrayList<Book> returnBook(String userInput) {
        Boolean match = false;

        for (Book book : listOfBooks) {
            if (book.getName().toLowerCase().contains(userInput)) {
                match = true;
                System.out.println("Thank you for returning the book");
                book.setIsAvailable(true);
                break;
            }
        }
        if (!match) {
            System.out.println("This book can't be returned");
        }
        return listOfBooks;
    }

}
