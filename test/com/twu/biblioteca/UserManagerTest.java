package com.twu.biblioteca;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserManagerTest {

    @Test
    public void authenticateUserShouldStartSessionWhenDetailsAreInsertedCorrectly() {
        String username = "rosapalli";
        String password = "abc12345";

        UserManager userManager = new UserManager();

        Boolean userCredentialsMatch;
        userCredentialsMatch = userManager.userAuthentication(username,password);

        assertThat(userCredentialsMatch, is(true));
    }

    @Test
    public void authenticateUserShouldNotStartSessionWhenDetailsAreInsertedIncorrectly() {
        String username = "rosapalli";
        String wrongPassword = "12345abc";

        UserManager userManager = new UserManager();

        Boolean userCredentialsMatch;
        userCredentialsMatch = userManager.userAuthentication(username, wrongPassword);

        assertThat(userCredentialsMatch, is(false));
    }

    @Test
    public void startSessionShouldCreateANewSessionForAUser() {
        String username = "rosapalli";

        UserManager userManager = new UserManager();

        UserSession userSession = userManager.startSession(username);

        assertThat(userSession.getSessionStarted(), is(true));
        assertThat(userSession.getUserName(), is("rosapalli"));
    }

    @Test
    public void findUserInformationShouldFindTheDetailsForALoggedInUser() {
        String username = "rosapalli";
        UserSession userSession = new UserSession(username);
        UserManager userManager = new UserManager();

        LibraryUser expectedUser = userManager.findUserInformation(username);

        assertThat(expectedUser.getName(), is("Rosa"));
        assertThat(expectedUser.getEmail(), is("rosa.palli@thoughtworks.com"));
    }

}
