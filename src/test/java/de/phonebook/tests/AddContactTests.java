package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("darnedu@gmail.com")
                .setPassword("Administrator!9"));
        clickOnLoginButton();

        clickOnAddLink();

        fillContactForm(new Contact()
                .setName("Oliver")
                .setLastName("Kan")
                .setPhone("1234567890")
                .setEmail("kan@gm.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));

        clickOnSaveButton();
        Assert.assertTrue(verifyContactByName("Oliver"));
    }

    @AfterMethod
    public void postCondition() {
        removeContact();
    }

}