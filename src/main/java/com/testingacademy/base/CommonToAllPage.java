package com.testingacademy.base;

import com.testingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.testingacademy.driver.DriverManager.getDriver;

public class CommonToAllPage {

    public CommonToAllPage() {
    }

    public void openVWOUrl() {
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by) {
        by.click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }
    public String getText(WebElement by) {
        return by.getText();
    }

public void custom_waits()
{
    try {
        Thread.sleep(10000);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
    public WebElement presenceOfElement(By ElementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(ElementLocation));
    }

    public WebElement visibilityOfElement(By ElementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(ElementLocation));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }
}
