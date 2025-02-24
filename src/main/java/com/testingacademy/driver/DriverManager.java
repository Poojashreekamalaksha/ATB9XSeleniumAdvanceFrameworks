package com.testingacademy.driver;

import com.testingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init() {
        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    ChromeOptions co = new ChromeOptions();
                    co.addArguments("--start-maximized");
                    co.addArguments("--guest");
                    driver = new ChromeDriver(co);
                    break;
            }

        }
    }
        public static void down()
        {
            if (driver != null)
                driver.quit();
            driver = null;
        }


    }

