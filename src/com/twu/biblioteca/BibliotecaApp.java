package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.go();

    }

    public void go() {
        WelcomeMessage welcome = new WelcomeMessage();
        welcome.displayWelcomeMessage();
        MenuOfOptions menu = new MenuOfOptions();
        menu.displayMenuOfOptions();
    }

    public void exitBiblioteca() {
        System.out.println("Thank you for visiting Biblioteca. We hope to see you soon!");
        System.exit(0);
    }

}
