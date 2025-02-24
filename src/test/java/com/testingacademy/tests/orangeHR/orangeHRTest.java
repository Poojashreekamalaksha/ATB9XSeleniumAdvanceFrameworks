package com.testingacademy.tests.orangeHR;

import com.testingacademy.pages.pageObjectModel.orangeHr.EmployeeListHoemPage;
import com.testingacademy.pages.pageObjectModel.orangeHr.LoginHRPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class orangeHRTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Owner("POOJASHREE")
    @Description("Verify the valid login credential for orangeHR page ")
    @Test
    public void testLoginorangeHR() {
        LoginHRPage login = new LoginHRPage(driver);
        login.loginHRCreds("admin", "Hacker@4321");
        String dashboard = driver.getCurrentUrl();
        Assert.assertEquals(dashboard, "https://awesomeqa.com/hr/web/index.php/pim/viewEmployeeList");


    }

    @Owner("POOJASHREE")
    @Description("Verify the dashboard page for orangeHR page ")
    @Test
    public void testLoginorangeHRDashBoard() {
        LoginHRPage login = new LoginHRPage(driver);
        login.loginHRCreds("admin", "Hacker@4321");
        String dashboard = driver.getCurrentUrl();
        Assert.assertEquals(dashboard, "https://awesomeqa.com/hr/web/index.php/pim/viewEmployeeList");
        EmployeeListHoemPage emp = new EmployeeListHoemPage(driver);
        String dashboardPage = emp.dashBoardPage();
        Assert.assertEquals(dashboardPage, "PIM");


    }

}

