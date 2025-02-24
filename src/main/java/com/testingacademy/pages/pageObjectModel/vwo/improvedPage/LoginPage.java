package com.testingacademy.pages.pageObjectModel.vwo.improvedPage;

import com.testingacademy.base.CommonToAllPage;
import com.testingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.id("login-username");
    private By password = By.name("password");
    private By signButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");

    public void loginToVWOLoginValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signButton);
        custom_waits();

    }

    public String loginToVWOLoginInValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signButton);
        presenceOfElement(errorMessage);
        return getText(errorMessage);


    }
}
