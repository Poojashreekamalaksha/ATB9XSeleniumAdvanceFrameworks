package com.testingacademy.pages.pageObjectModel.katalon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {
    WebDriver driver;
    private By appointmentButton = By.id("btn-make-appointment");
    private By facility = By.id("combo_facility");
    private By readmission = By.xpath("//input[@id='chk_hospotal_readmission']");
    private By readmhealthProgram = By.id("radio_program_medicaid");
    private By visitDate = By.xpath("//input[@id='txt_visit_date']");
    private By currentDate = By.xpath("//td[@class='active day']");
    private By comment = By.id("txt_comment");
    private By btn = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }


    public String appointmentValidation() {
        driver.findElement(appointmentButton).click();
        Select sel = new Select(driver.findElement(facility));
        sel.selectByValue("Hongkong CURA Healthcare Center");
        driver.findElement(readmission).click();
        driver.findElement(readmhealthProgram).click();
        sleep(10000);
        //driver.findElement(visitDate).click();
        driver.findElement(visitDate).sendKeys("21/02/2025"); // Click to open the calendar
        sleep(10000);
        driver.findElement(comment).sendKeys("Book Appointment");
        driver.findElement(btn).click();
        sleep(5000);
        return driver.getCurrentUrl();

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
