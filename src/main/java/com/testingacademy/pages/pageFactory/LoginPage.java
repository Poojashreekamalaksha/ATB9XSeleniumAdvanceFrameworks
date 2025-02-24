package com.testingacademy.pages.pageFactory;

import com.testingacademy.base.CommonToAllPage;
import com.testingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonToAllPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    //Page Locators

    //Page Actions
    @FindBy(id="login-username")
    private WebElement username;

    @FindBy(name="password")
    private WebElement password;
    @FindBy(id="js-login-btn")
    private WebElement signIn;
    @FindBy(id="js-notification-box-msg")
    private WebElement error;
    public void loginToVWOLoginValidCreds() {
        openVWOUrl();
        enterInput(username, PropertiesReader.readKey("invalidusernamed"));
        enterInput(password, PropertiesReader.readKey("invalidpassword"));
        clickElement(signIn);
        custom_waits();


    }
    public String loginToVWOLoginInValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username, PropertiesReader.readKey("validusername"));
        enterInput(password, PropertiesReader.readKey("validpassword"));
        clickElement(signIn);
        custom_waits();
      return getText(error);


    }

}
