package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListOfBooksTest {

    @Test
    public void createArrayListOfBooksShouldCreateAListOfBooksTest() {
        BookManager list = new BookManager();
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
    public void checkoutBookShouldMakeBookNotAvailable() {
        BookManager list = new BookManager();

        String userInput = "Catch-22";
        list.checkoutBook(userInput);

        assertThat(list.getListOfBooks().get(2).getIsAvailable(), is(false));
    }

    @Test
    public void returnBookShouldMakeBookAvailable() {
        BookManager list = new BookManager();

        list.getListOfBooks().get(2).setIsAvailable(false);

        String userInput = "Catch-22";
        list.returnBook(userInput);

        assertThat(list.getListOfBooks().get(2).getIsAvailable(), is(true));
    }

}


