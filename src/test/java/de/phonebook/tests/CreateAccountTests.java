package de.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        driver.findElement(By.cssSelector("[href='/login']")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("darndeu@gmail.com");

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Administrator!9");

        driver.findElement(By.name("registration")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
    }

    @Test
    public void existedUserRegisterNegativeTest() {
        driver.findElement(By.cssSelector("[href='/login']")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("darndeu@gmail.com");

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Administrator!9");

        driver.findElement(By.name("registration")).click();
        Assert.assertTrue(isAlertPresent());
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;

        } else {
            return true;
        }
    }

}