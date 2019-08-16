package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieManager implements LibraryManager {

    private ArrayList<Movie> listOfMovies;

    public MovieManager() {
         createListOfItems();
     }

    public ArrayList<Movie> getListOfMovies() {
        return listOfMovies;
    }

    @Override
    public void createListOfItems() {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Fear and Loathing in Las Vegas", "Terry Gilliam", 1999, 7.6f));
        list.add(new Movie("The Great Lebowski", "Ethan Coen, Joel Coen", 1998, 8.1f));
        list.add(new Movie("Mulan", "Tony Bancroft, Barry Cook", 1998, 7.6f));
        listOfMovies = list;
    }

    @Override
    public ArrayList<Movie> checkoutItem(String movieName, String username) {
        Boolean match = false;

        for(Movie movie : getListOfMovies()) {
            String movieNameInList = movie.getName().toLowerCase();
            if (movieNameInList.contains(movieName) && movie.getIsAvailable()) {
                movie.setIsAvailable(false);
                movie.setLoanedByUsername(username);
                match = true;
                System.out.println("Thank you! Enjoy the movie");
                break;
            }
        }
        if (!match) {
            System.out.println("Sorry, that movie is not available");
        }
        return listOfMovies;
    }

    @Override
    public ArrayList<Movie> returnItem(String movieName) {
        Boolean match = false;

        for (Movie movie : listOfMovies) {
            if (movie.getName().toLowerCase().contains(movieName) && !movie.getIsAvailable()) {
                movie.setIsAvailable(true);
                movie.setLoanedByUsername(null);
                match = true;
                System.out.println("Thank you for returning the movie");

                break;
            }
        }
        if (!match) {
            System.out.println("This movie can't be returned");
        }
        return listOfMovies;
    }

    public void setListOfMovies(ArrayList<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }
}
