package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class ListOfBooksTest {

    @Test
    public void ShouldCreateAListOfBooksTest() {
        ListOfBooks listOfBooks = new ListOfBooks();
        ArrayList<Book> list = listOfBooks.createListOfBooks();
        String bookName = list.get(0).getName();
        String bookAuthor = list.get(0).getAuthor();
        Integer bookYearPublished = list.get(0).getYearPublished();

        Book expectedBook = new Book("1984", "George Orwell", 1948);

        assertEquals(expectedBook.getName(), bookName);
        assertEquals(expectedBook.getAuthor(), bookAuthor);
        assertEquals(expectedBook.getYearPublished(), bookYearPublished);
    }



//    @Test
//    public void shouldRemoveBookFromList(Book book) {
////        //given
////        ArrayList<Book> listOfBooks = new ArrayList<Book>();
////
////        listOfBooks.add(new Book("1984", "George Orwell", 1948));
////        listOfBooks.add(new Book("The Brothers Karamazov", "Fiodor Dostoyevski", 1880));
////        listOfBooks.add(new Book("Catch-22", "Joseph Heller", 1953));
////
////        //when
////        listOfBooks.checkoutBook();
////        //then
////        //the li
//    }
}


