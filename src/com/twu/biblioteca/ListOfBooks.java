package com.twu.biblioteca;

import java.util.ArrayList;

public class ListOfBooks {

    public ArrayList<Book> createListOfBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("1984", "George Orwell", 1948));
        listOfBooks.add(new Book("The Brothers Karamazov", "Fiodor Dostoyevski", 1880));
        listOfBooks.add(new Book("Catch-22", "Joseph Heller", 1953));
        return listOfBooks;
    }

    public void displayListOfBooks(ArrayList<Book> listOfBooks) {
        for (Book book : listOfBooks) {
            System.out.printf("%-30s %-2s %-30s %-2s %-30s\n", book.getName(), "|", book.getAuthor(), "|", book.getYearPublished());
        }
    }

    public void checkoutBook() {
        //if a book is checked out, it should not appear on listOfBooks
        //Successful book checkout display message: Thank you! Enjoy the book
        //If book not available / miss-spelled display “Sorry, that book is not available”
    }

    public void returnBook() {
        //if a book is returned, it should reappear on listOfBooks
        //Display message - Thank you for returning the book.
        //If book to be returned does not belong to the library, (or miss-spelled) display: That is not a valid book to return
    }

}

//how do we check if a book appears or doesn't appear on list of books after selecting list of books from menu of options?
//should there be a way to return to menu of options? user to choose whether return to menu of options or quit after checking out/returning book?
