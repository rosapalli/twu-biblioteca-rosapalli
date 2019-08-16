package com.twu.biblioteca;

import java.util.ArrayList;

public class BookManager implements LibraryManager {

    private ArrayList<Book> listOfBooks;

    public BookManager() {
        createListOfItems();
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    @Override
    public void createListOfItems() {
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("1984", "George Orwell", 1948));
        list.add(new Book("The Brothers Karamazov", "Fiodor Dostoyevski", 1880));
        list.add(new Book("Catch-22", "Joseph Heller", 1953));
        listOfBooks = list;
    }

    @Override
    public ArrayList<Book> checkoutItem(String bookName, String username) {
        Boolean match = false;

        for(Book book : getListOfBooks() ) {
            if (book.getName().toLowerCase().contains(bookName) && book.getIsAvailable().equals(true)) {
                book.setIsAvailable(false);
                book.setLoanedByUsername(username);
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

    @Override
    public ArrayList<Book> returnItem(String bookName) {
        Boolean match = false;

        for (Book book : listOfBooks) {
            if (book.getName().toLowerCase().contains(bookName) && !book.getIsAvailable()) {
                match = true;
                System.out.println("Thank you for returning the book");
                book.setIsAvailable(true);
                book.setLoanedByUsername(null);
                break;
            }
        }
        if (!match) {
            System.out.println("This book can't be returned");
        }
        return listOfBooks;
    }

    public void setListOfBooks(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }
}
