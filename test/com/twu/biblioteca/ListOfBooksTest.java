package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListOfBooksTest {

    @Test
    public void ShouldCreateAListOfBooksTest() {
        ListOfBooks list = new ListOfBooks();
        list.createArrayListOfBooks();
        String bookName = list.getListOfBooks().get(0).getName();
        String bookAuthor = list.getListOfBooks().get(0).getAuthor();
        Integer bookYearPublished = list.getListOfBooks().get(0).getYearPublished();

        Book expectedBook = new Book("1984", "George Orwell", 1948);

        assertThat((expectedBook.getName()), is(bookName));
        assertThat((expectedBook.getAuthor()), is(bookAuthor));
        assertThat((expectedBook.getYearPublished()), is(bookYearPublished));
    }

    @Test
    public void shouldRemoveBookFromList() {
        ListOfBooks list = new ListOfBooks();
        list.createArrayListOfBooks();

        String userInput = "1984";
        ArrayList<Book> updatedListOfBooks = list.checkoutBook(userInput);

        assertThat(updatedListOfBooks.size(), is(2));
    }

    @Test
    public void shouldNotRemoveBookFromList() {
        ListOfBooks list = new ListOfBooks();
        list.createArrayListOfBooks();

        String userInput = "Foo";
        ArrayList<Book> updatedListOfBooks = list.checkoutBook(userInput);

        assertThat(updatedListOfBooks.size(), is(3));
    }

    @Test
    public void shouldAddBookToList() {
        ListOfBooks list = new ListOfBooks();
        list.createArrayListOfBooks();
        String userInput = "1984";
        list.checkoutBook(userInput);

        list.returnBook(userInput);

        assertThat(list.getListOfBooks().size(), is(3));
    }

    @Test
    public void shouldNotAddBookToList() {
        ListOfBooks list = new ListOfBooks();
        list.createArrayListOfBooks();
        String existingBook = "1984";
        String nonExistingBook = "0000";
        list.checkoutBook(existingBook);

        list.returnBook(nonExistingBook);

        assertThat(list.getListOfBooks().size(), is (2));
    }
}


