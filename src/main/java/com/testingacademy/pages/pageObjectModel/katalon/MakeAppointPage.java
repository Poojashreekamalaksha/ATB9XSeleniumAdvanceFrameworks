package com.testingacademy.pages.pageObjectModel.katalon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MakeAppointPage {
    WebDriver driver;
    private By makeAppointmentButton = By.linkText("Make Appointment");
    private By loginText = By.xpath("//p[@class='lead']");

    public MakeAppointPage(WebDriver driver) {
        this.driver = driver;
    }

    public String makeAppointmentValidation() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        sleep(5000);
        driver.findElement(makeAppointmentButton).click();
        sleep(5000);
        return driver.findElement(loginText).getText();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
