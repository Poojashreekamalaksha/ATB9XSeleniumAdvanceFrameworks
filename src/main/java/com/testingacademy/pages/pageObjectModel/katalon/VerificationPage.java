package com.testingacademy.pages.pageObjectModel.katalon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerificationPage {
    WebDriver driver;
    private By confirmation = By.xpath("//h2[normalize-space()='Appointment Confirmation']");

    public VerificationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verificationValidation() {
        sleep(5000);
        return driver.findElement(confirmation).getText();

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
