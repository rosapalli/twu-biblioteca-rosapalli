package com.twu.biblioteca;

public class Biblioteca {
    public void go() {
        TerminalDisplay terminal = new TerminalDisplay();
        MenuOfOptions menu = new MenuOfOptions();
        BookManager list = new BookManager();

        terminal.displayWelcomeMessage();
        terminal.displayMenuOfOptions(menu);
        String userInput = terminal.captureUserInput();

        while (!userInput.contains("exit")) {
            switch (userInput) {
                case "exit":
                    break;
                case "list":
                    terminal.displayListOfBooks(list.getListOfBooks());
                    break;
                case "checkout":
                    System.out.println("Please type the title of the book you would like to check out");
                    userInput = terminal.captureUserInput();
                    list.checkoutBook(userInput);
                    break;
                case "return":
                    System.out.println("Please type the title of the book you would like to return");
                    userInput = terminal.captureUserInput();
                    list.returnBook(userInput);
                    break;
                default:
                    System.out.println("Please select a valid option!");
            }
            terminal.displayMenuOfOptions(menu);
            userInput = terminal.captureUserInput();
        }
    }

    public void exitBiblioteca() {
        System.out.println("Thank you for visiting Biblioteca. We hope to see you soon!");
        System.exit(0);
    }

}
