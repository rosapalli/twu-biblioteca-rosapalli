package com.twu.biblioteca;

import com.sun.codemodel.internal.JMethod;

import java.util.HashMap;

public class Biblioteca {

    TerminalDisplay terminal;
    BookManager bookManager;
    MovieManager movieManager;
    UserManager userManager;
    UserSession userSession;
    MenuOfOptions menu;

    public Biblioteca() {
         this.terminal = new TerminalDisplay();
         this.bookManager = new BookManager();
         this.movieManager = new MovieManager();
         this.userManager = new UserManager();
         this.userSession = new UserSession();
         this.menu = new MenuOfOptions();
    }

    public void go() {
        terminal.displayWelcomeMessage();
        terminal.displayMenuOfOptions(menu);
        String userInput = terminal.captureUserInput();
        selectOptionFromMainMenu(userInput);
    }

    public void exitBiblioteca() {
        System.out.println("Thank you for visiting Biblioteca. We hope to see you soon!");
        System.exit(0);
    }

    public void selectOptionFromMainMenu(String userInput) {
        while (!userInput.contains("exit")) {

            HashMap<String, JMethod> hashMap = new HashMap<>();

            switch (userInput) {
                case "exit":
                    break;
                case "books":
                    terminal.displayListOfBooks(bookManager.getListOfBooks());
                    break;
                case "movies":
                    terminal.displayListOfMovies(movieManager.getListOfMovies());
                    break;
                case "checkout":
                    System.out.println("Please press 1 if you would like to check out a BOOK");
                    System.out.println("Please press 2 if you would like to check out a MOVIE");
                    userInput = terminal.captureUserInput();
                    selectTypeOfLibraryItemForCheckout(userInput);
                    break;
                case "return":
                    System.out.println("Please press 1 if you would like return a BOOK");
                    System.out.println("Please press 2 if you would like return a MOVIE");
                    userInput = terminal.captureUserInput();
                    selectTypeOfLibraryItemToReturn(userInput);
                    break;
                case "login":
                    System.out.println("Please enter your username");
                    String username = terminal.captureUserInput();
                    System.out.println("Please enter your password");
                    String password = terminal.captureUserInput();
                    userSession = userManager.loginUser(username, password);
                    break;
                case "details":
                    String userName = userSession.getUserName();
                    LibraryUser currentUser = userManager.findUserInformation(userName);
                    terminal.displayUserInformation(currentUser, userSession);
                    break;
                case "my loans":
                    terminal.displayUserCurrentItemsCheckedOut(bookManager.getListOfBooks(), movieManager.getListOfMovies(), userSession);
                    break;
                default:
                    System.out.println("Please select a valid option!");
            }
            terminal.displayMenuOfOptions(menu);
            userInput = terminal.captureUserInput();
        }
    }

    public void selectTypeOfLibraryItemForCheckout(String userInput) {
        if (userSession.getSessionStarted()) {
            switch (userInput) {
                case "1":
                    System.out.println("Enter the name of the book you would like to check out");
                    String bookName = terminal.captureUserInput();
                    bookManager.setListOfBooks(bookManager.checkoutItem(bookName, userSession.getUserName()));
                    break;
                case "2":
                    System.out.println("Enter the name of the film you would like to check out");
                    String movieName = terminal.captureUserInput();
                    movieManager.setListOfMovies(movieManager.checkoutItem(movieName, userSession.getUserName()));
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } else {
            System.out.println("Please log in to check out a movie or a book");
        }
    }

    public void selectTypeOfLibraryItemToReturn(String userInput) {
        if(userSession.getSessionStarted()) {
            switch (userInput) {
                case "1":
                    System.out.println("Enter the name of the book you would like to return");
                    String bookName = terminal.captureUserInput();
                    bookManager.setListOfBooks(bookManager.returnItem(bookName));
                    break;
                case "2":
                    System.out.println("Enter the name of the film you would like to return");
                    String movieName = terminal.captureUserInput();
                    movieManager.setListOfMovies(movieManager.returnItem(movieName));
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } else {
            System.out.println("PLease log in to return a movie or a book");
        }
    }
}
