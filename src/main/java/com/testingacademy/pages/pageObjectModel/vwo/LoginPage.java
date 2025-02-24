package com.testingacademy.pages.pageObjectModel.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private By username = By.id("login-username");
    private By password = By.name("password");
    private By signButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");

    public void loginToVWOLoginValidCreds(String user, String pwd) {
        driver.get("https://app.vwo.com/");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

    }

    public String loginToVWOLoginInValidCreds(String user, String pwd) {
        driver.get("https://app.vwo.com/");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String errorMessageText = driver.findElement(errorMessage).getText();
        return errorMessageText;
    }
}
