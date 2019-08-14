package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalDisplay {


    public String captureUserInput() {
        Scanner myObj = new Scanner(System.in);
        String userInput = myObj.nextLine();
        userInput.toLowerCase();
        return userInput;
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void displayMenuOfOptions(MenuOfOptions menu) {
        System.out.println("-------------------------------");
        System.out.println("WHAT WOULD YOU LIKE TO DO NEXT?");
        System.out.println("MENU OF OPTIONS:");
        for (String option: menu.options) {
            System.out.println(option);
        }
    }

    public void displayListOfBooks(ArrayList<Book> listOfBooks) {
        System.out.println("LIST OF CURRENTLY AVAILABLE BOOKS");
        System.out.println("-----------------------------------------------------------------------------");

        System.out.printf("%-30s %-2s %-30s %-2s %-30s\n", "TITLE", "|", "AUTHOR", "|", "YEAR PUBLISHED");
        System.out.println("-----------------------------------------------------------------------------");
        for (Book book : listOfBooks) {
            if (book.getIsAvailable()) {
                System.out.printf("%-30s %-2s %-30s %-2s %-30s\n", book.getName(), "|", book.getAuthor(), "|", book.getYearPublished());
            }
        }
    }

}
