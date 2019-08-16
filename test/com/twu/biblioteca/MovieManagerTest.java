package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieManagerTest {

    @Test
    public void createListOfMoviesShouldCreateAListOfMovies() {
        MovieManager list = new MovieManager();
        list.createListOfItems();

        String movieName = list.getListOfMovies().get(0).getName();
        String movieAuthor = list.getListOfMovies().get(0).getAuthor();
        Integer movieYear = list.getListOfMovies().get(0).getYear();
        Float movieRating = list.getListOfMovies().get(0).getRating();
        String movieLoanedByUsername = list.getListOfMovies().get(0).getLoanedByUsername();
        Boolean movieIsAvailable = list.getListOfMovies().get(0).getIsAvailable();

        Movie expectedMovie = new Movie("Fear and Loathing in Las Vegas", "Terry Gilliam", 1999, 7.6f);
        assertThat((expectedMovie.getName()), is(movieName));
        assertThat((expectedMovie.getAuthor()), is(movieAuthor));
        assertThat((expectedMovie.getYear()), is(movieYear));
        assertThat((expectedMovie.getRating()), is(movieRating));
        assertThat((expectedMovie.getLoanedByUsername()), is(movieLoanedByUsername));
        assertThat((expectedMovie.getIsAvailable()), is(movieIsAvailable));
    }

    @Test
    public void checkoutItemShouldMakeBookNotAvailable() {
        MovieManager list = new MovieManager();

        String movieName = "mulan";
        String username = "rosapalli";
        list.checkoutItem(movieName, username);

        assertThat(list.getListOfMovies().get(2).getIsAvailable(), is(false));
    }

    @Test
    public void checkoutItemShouldNotChangeTheStateOfABookIfTheBookIsAlreadyAvailable() {

    }

    @Test
    public void checkoutItemShouldNotChangeTheStateOfABookIfTheUserInputIsNotValid(){

    }

    @Test
    public void returnItemShouldMakeMovieAvailable() {
        MovieManager list = new MovieManager();

        list.getListOfMovies().get(2).setIsAvailable(false);

        String movieName = "mulan";
        String username = null;
        list.returnItem(movieName);

        assertThat(list.getListOfMovies().get(2).getIsAvailable(), is(true));
        assertThat(list.getListOfMovies().get(2).getLoanedByUsername(), is(username));
    }

    @Test
    public void returnBookShouldNotChangeTheStateOfABookIfTheBookIsAlreadyAvailable() {

    }

    @Test
    public void returnBookShouldNotChangeTheStateOfABookIfTheUserInputIsNotValid(){

    }


}