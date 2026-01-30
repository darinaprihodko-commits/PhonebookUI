package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("darnedu@gmail.com")
                .setPassword("Administrator!9"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(new Contact()
                .setName("Oliver")
                .setLastName("Kan")
                .setPhone("1234567890")
                .setEmail("kan@gm.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));

        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().verifyContactByName("Oliver"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }
}