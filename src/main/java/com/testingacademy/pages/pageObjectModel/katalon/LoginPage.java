package com.testingacademy.pages.pageObjectModel.katalon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    private By userName = By.id("txt-username");
    private By passWord = By.id("txt-password");
    private By login = By.id("btn-login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void loginPageValidation(String user, String pw) {

        sleep(10000);
        driver.findElement(userName).sendKeys(user);
        driver.findElement(passWord).sendKeys(pw);
        driver.findElement(login).click();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



