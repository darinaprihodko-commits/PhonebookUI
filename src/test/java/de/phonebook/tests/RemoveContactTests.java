package de.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("darnedu@gmail.com")
                .setPassword("Administrator!9"));
        clickOnLoginButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[href='/add']")));

        clickOnAddLink();

        clickOnAddLink();

        fillContactForm(new Contact()
                .setName("Oliver")
                .setLastName("Kan")
                .setPhone("1234567890")
                .setEmail("kan@gm.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        clickOnSaveButton();
    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = sizeOfContacts();
        removeContact();

        pause(500);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
