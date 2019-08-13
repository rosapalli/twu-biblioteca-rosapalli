package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ListOfBooksTest {

    @Test
    public void ShouldCreateAListOfBooks() {
        // given

        //when
        biblioteca.go();
        //then
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", systemOutRule.log());
    }
}


