package com.testingacademy.pages.pageObjectModel.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {

    WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }
   private By userNameDashboard=By.cssSelector("[data-qa=\"lufexuloga\"]");
    public String loggedInUser()
    {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       String user=driver.findElement(userNameDashboard).getText();
       return user;
    }
}
