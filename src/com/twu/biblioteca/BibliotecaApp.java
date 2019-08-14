package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.go();
        biblioteca.exitBiblioteca();
    }

    public void go() {

        TerminalDisplay terminal = new TerminalDisplay();
        MenuOfOptions menu = new MenuOfOptions();
        ListOfBooks list = new ListOfBooks();
        list.createArrayListOfBooks();
        menu.populateMenuOfOptions();

        terminal.displayWelcomeMessage();
        terminal.displayMenuOfOptions(menu);
        String userInput = terminal.captureUserInput();

        while (!userInput.contains("exit")) {

            if (userInput.contains("exit")) {
                break;
            } else if (userInput.contains("list")) {
                terminal.displayListOfBooks(list.getListOfBooks());

            } else if (userInput.contains("checkout")) {
                System.out.println("Please type the title of the book you would like to check out");
                userInput = terminal.captureUserInput();
                list.checkoutBook(userInput);

            } else if (userInput.contains("return")) {
                System.out.println("Please type the title of the book you would like to return");
                userInput = terminal.captureUserInput();
                list.returnBook(userInput);
            } else {
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
