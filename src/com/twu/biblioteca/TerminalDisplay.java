package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalDisplay {

    public String captureUserInput() {
        Scanner myObj = new Scanner(System.in);
        String userInput = myObj.nextLine();
        userInput = userInput.toLowerCase();
        return userInput;
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void displayMenuOfOptions(MenuOfOptions menu) {
        System.out.println("-------------------------------");
        System.out.println("WHAT WOULD YOU LIKE TO DO NEXT?");
        System.out.println("MENU OF OPTIONS:");
        for (String option : menu.options) {
            System.out.println(option);
        }
    }

    public void displayListOfBooks(ArrayList<Book> listOfBooks) {
        System.out.println("LIST OF CURRENTLY AVAILABLE BOOKS");
        System.out.printf("%-30s %-2s %-30s %-2s %-30s\n", "TITLE", "|", "AUTHOR", "|", "YEAR PUBLISHED");
        for (Book book : listOfBooks) {
            if (book.getIsAvailable()) {
                System.out.printf("%-30s %-2s %-30s %-2s %-30s\n", book.getName(), "|", book.getAuthor(), "|", book.getYear());
            }
        }
    }

    public void displayListOfMovies(ArrayList<Movie> listOfMovies) {
        System.out.println("LIST OF CURRENTLY AVAILABLE MOVIES");
        System.out.printf("%-30s %-2s %-30s %-2s %-30s %-2s %-30s\n", "TITLE", "|", "DIRECTOR", "|", "RELEASE YEAR", "|", "RATING");
        for (Movie movie : listOfMovies) {
            if (movie.getIsAvailable()) {
                System.out.printf("%-30s %-2s %-30s %-2s %-30s %-2s %-30s\n", movie.getName(), "|", movie.getAuthor(), "|", movie.getYear(), "|'", movie.getRating());
            }
        }
    }

    public void displayUserInformation(LibraryUser user, UserSession userSession) {
        if (userSession.getSessionStarted()) {
            System.out.println("Hello " + user.getName());
            System.out.println("Here are your library user details:");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Phone number: " + user.getPhoneNumber());
            System.out.println("Email: " + user.getEmail());
        } else {
            System.out.println("You must be logged in to see your details");
        }
    }

    public void displayUserCurrentItemsCheckedOut(ArrayList<Book> listOfBooks, ArrayList<Movie> listOfMovies, UserSession userSession) {
        Boolean match = false;
        if (userSession.getSessionStarted()) {
            System.out.println("YOU CURRENTLY HAVE LOANED THESE MOVIES");
            System.out.printf("%-30s %-2s %-30s %-2s %-30s %-2s %-30s\n", "TITLE", "|", "DIRECTOR", "|", "RELEASE YEAR", "|", "RATING");
            for (Movie movie : listOfMovies) {
                if (!movie.getIsAvailable() || userSession.getUserName().equals(movie.getLoanedByUsername())) {
                    System.out.printf("%-30s %-2s %-30s %-2s %-30s %-2s %-30s\n", movie.getName(), "|", movie.getAuthor(), "|", movie.getYear(), "|'", movie.getRating());
                    match = true;
                }
            }
            System.out.println("YOU CURRENTLY HAVE LOANED THESE BOOKS");
            System.out.printf("%-30s %-2s %-30s %-2s %-30s\n", "TITLE", "|", "AUTHOR", "|", "YEAR PUBLISHED");
            for (Book book : listOfBooks) {
                if (!book.getIsAvailable()) {
                    System.out.printf("%-30s %-2s %-30s %-2s %-30s\n", book.getName(), "|", book.getAuthor(), "|", book.getYear());
                    match = true;
                }
            }
            if(!match) {
                System.out.println("You have no items currently on loan");
            }
        } else {
            System.out.println("Please log in to see checked out items");
        }
    }
}
