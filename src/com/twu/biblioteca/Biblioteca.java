package com.twu.biblioteca;

public class Biblioteca {
    public void go() {
        TerminalDisplay terminal = new TerminalDisplay();
        MenuOfOptions menu = new MenuOfOptions();
        BookManager bookManager = new BookManager();
        MovieManager movieManager = new MovieManager();
        UserSession userSession = new UserSession();
        UserManager userManager = new UserManager();

        terminal.displayWelcomeMessage();
        terminal.displayMenuOfOptions(menu);
        String userInput = terminal.captureUserInput();
        selectOptionFromMainMenu(userInput, terminal, bookManager, movieManager, menu, userSession, userManager);
    }

    public void exitBiblioteca() {
        System.out.println("Thank you for visiting Biblioteca. We hope to see you soon!");
        System.exit(0);
    }

    public void selectOptionFromMainMenu(String userInput, TerminalDisplay terminal, BookManager bookManager, MovieManager movieManager, MenuOfOptions menu, UserSession userSession, UserManager userManager) {
        while (!userInput.contains("exit")) {
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
                    selectTypeOfLibraryItemForCheckout(userSession, userInput, terminal, bookManager, movieManager);
                    break;
                case "return":
                    System.out.println("Please press 1 if you would like return a BOOK");
                    System.out.println("Please press 2 if you would like return a MOVIE");
                    userInput = terminal.captureUserInput();
                    selectTypeOfLibraryItemToReturn(userInput, terminal, bookManager, movieManager, userSession);
                    break;
                case "login":
                    System.out.println("Please enter your username");
                    String username = terminal.captureUserInput();
                    System.out.println("Please enter your password");
                    String password = terminal.captureUserInput();
                    userSession = loginUser(username, password, userManager);
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

    public void selectTypeOfLibraryItemForCheckout(UserSession userSession, String userInput, TerminalDisplay terminal, BookManager bookManager, MovieManager movieManager) {
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

    public void selectTypeOfLibraryItemToReturn(String userInput, TerminalDisplay terminal, BookManager bookManager, MovieManager movieManager, UserSession userSession) {
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

    public UserSession loginUser(String username, String password, UserManager userManager) {
        UserSession userSession = null;
        Boolean validUser = userManager.userAuthentication(username, password);
            if (validUser) {
                userSession = userManager.startSession(username);
                System.out.println("Session started successfully for " + username);
            } else {
                System.out.println("Wrong credentials.Please try again.");
            }
            return userSession;
    }
}
