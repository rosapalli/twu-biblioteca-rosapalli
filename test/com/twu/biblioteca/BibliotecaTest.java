package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {

    @Test
    public void selectOptionFromMainMenuShouldExitTheApplication() {
    }

    @Test
    public void selectOptionFromMainMenuShouldDisplayAListOfBooks() {

    }

    @Test
    public void selectOptionFromMainMenuShouldDisplayAListOfMovies() {

    }

    @Test
    public void selectTypeOfLibraryItemForCheckoutShouldCheckoutABook() {
    }

    @Test
    public void selectTypeOfLibraryItemForCheckoutShouldCheckoutAMovie() {
    }

    @Test
    public void selectTypeOfLibraryItemToReturnShouldReturnABook() {
    }

    @Test
    public void selectTypeOfLibraryItemToReturnShouldReturnAMovie() {

    }

    @Test
    public void loginUserShouldStartASessionForAnAuthenticatedUser() {
        Biblioteca biblioteca = new Biblioteca();
        UserManager userManager = new UserManager();
        String username = "rosapalli";
        String password = "abc12345";

        UserSession expectedUserSession = new UserSession(username);
        UserSession testUserSession = biblioteca.loginUser(username, password, userManager);

        assertThat(testUserSession.getSessionStarted(), is(expectedUserSession.getSessionStarted()));
        assertThat(testUserSession.getUserName(), is(expectedUserSession.getUserName()));
    }

    @Test
    public void loginUserShouldNotStartASessionForAUserWithWrongCredentials() {
        Biblioteca biblioteca = new Biblioteca();
        UserManager userManager = new UserManager();
        String username = "rosapalli";
        String password = "12345";

        UserSession testUserSession = biblioteca.loginUser(username, password, userManager);
        UserSession expectedUserSession = null;
        assertThat(testUserSession, is(expectedUserSession));
    }
}