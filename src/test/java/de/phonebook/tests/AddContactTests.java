package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AddContactTests extends TestBase {

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
                .setPhone("12345678910")
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