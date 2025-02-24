package com.testingacademy.pages.pageObjectModel.orangeHr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListHoemPage {
    WebDriver driver;

    public EmployeeListHoemPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dashBoardtext = By.xpath("//h6[text()='PIM']");

    public String dashBoardPage() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(dashBoardtext).getText();
    }
    //h6[text()='PIM']
}
