package de.phonebook.tests;

import de.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponentPresentTest() {
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }
}