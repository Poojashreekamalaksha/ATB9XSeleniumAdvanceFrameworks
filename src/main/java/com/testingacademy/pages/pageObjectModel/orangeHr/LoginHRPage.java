package com.testingacademy.pages.pageObjectModel.orangeHr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHRPage {
    WebDriver driver;

    public LoginHRPage(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.xpath("//input[@placeholder='Username']");

    private By password = By.xpath("//input[@placeholder='Password']");
    private By submit = By.cssSelector(" button[type='submit']");

    public void loginHRCreds(String user, String pw) {
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pw);

        driver.findElement(submit).click();
    }
}

