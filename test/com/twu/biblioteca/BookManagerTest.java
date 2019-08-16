package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookManagerTest {

    @Test
    public void createArrayListOfBooksShouldCreateAListOfBooksTest() {
        BookManager list = new BookManager();
        list.createListOfItems();

        String bookName = list.getListOfBooks().get(0).getName();
        String bookAuthor = list.getListOfBooks().get(0).getAuthor();
        Integer bookYearPublished = list.getListOfBooks().get(0).getYear();

        Book expectedBook = new Book("1984", "George Orwell", 1948);

        assertThat((expectedBook.getName()), is(bookName));
        assertThat((expectedBook.getAuthor()), is(bookAuthor));
        assertThat((expectedBook.getYear()), is(bookYearPublished));
    }

    @Test
    public void checkoutBookShouldMakeBookNotAvailable() {
        BookManager list = new BookManager();

        String userInput = "Catch-22";
        String username = "rosapalli";
        list.checkoutItem(userInput, username);

        assertThat(list.getListOfBooks().get(2).getIsAvailable(), is(false));
    }

    @Test
    public void returnBookShouldMakeBookAvailableWhenTypedExactlyAsTheNameOfTheBook() {
        BookManager list = new BookManager();

        list.getListOfBooks().get(2).setIsAvailable(false);

        String bookName = "Catch-22";
        list.returnItem(bookName);
        String username = null;

        assertThat(list.getListOfBooks().get(2).getIsAvailable(), is(true));
        assertThat(list.getListOfBooks().get(2).getLoanedByUsername(), is(username));
    }

    @Test
    public void returnBookShouldMakeBookAvailableWhenTypedAllInLowerCase() {

    }

    @Test
    public void returnBookShouldMakeBookAvailableWhenOnlyPartOfTheNameIsTyped() {

    }

}


