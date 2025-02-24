package com.testingacademy.tests.vwo;

import com.testingacademy.base.CommonToAllTest;
import com.testingacademy.driver.DriverManager;
import com.testingacademy.pages.pageObjectModel.vwo.DashBoardPage;
import com.testingacademy.pages.pageObjectModel.vwo.LoginPage;
import com.testingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.testingacademy.driver.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class vwoTest_PropertyReader extends CommonToAllTest {


    @Owner("POOJASHREE")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {


        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage_VWO.loginToVWOLoginInValidCreds(PropertiesReader.readKey("invalidusername"),PropertiesReader.readKey("invalidpassword"));

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("errormessage"));


    }

    @Owner("POOJASHREE")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {


        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("validusername"),PropertiesReader.readKey("validpassword"));
        DashBoardPage dashBoardPage  = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUser();


        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("dashboardmessage"));


    }
}

