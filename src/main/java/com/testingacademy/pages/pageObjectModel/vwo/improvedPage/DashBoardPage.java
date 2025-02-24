package com.testingacademy.pages.pageObjectModel.vwo.improvedPage;

import com.testingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage extends CommonToAllPage {

    WebDriver driver;

    public DashBoardPage(WebDriver driver) {

        this.driver = driver;
    }
   private By userNameDashboard= By.cssSelector("[data-qa=\"lufexuloga\"]");
    public String loggedInUser()
    {
        presenceOfElement(userNameDashboard);
        return getText(userNameDashboard);

    }
}
