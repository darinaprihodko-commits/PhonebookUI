package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("**@**.**")
                .setPassword("********"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setPassword("********"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());
    }

}