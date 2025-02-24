package com.testingacademy.tests.vwo.PageFactory;

import com.testingacademy.base.CommonToAllTest;
import com.testingacademy.driver.DriverManager;
import com.testingacademy.listeners.RetryAnalyzer;
import com.testingacademy.pages.pageObjectModel.vwo.DashBoardPage;
import com.testingacademy.pages.pageObjectModel.vwo.LoginPage;
import com.testingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class vwoTest_PropertyReaderImprovedPF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(vwoTest_PropertyReaderImprovedPF.class);
    @Owner("POOJASHREE")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {

        logger.info("ChromeDriver initialized");
        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        logger.info("Entering invalid username and password");
        String error_msg = loginPage_VWO.loginToVWOLoginInValidCreds(PropertiesReader.readKey("invalidusername"),PropertiesReader.readKey("invalidpassword"));
        logger.info("asserting error message and expected message");
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("errormessage"));


    }

    @Owner("POOJASHREE")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        logger.info("ChromeDriver initialized");
        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        logger.info("Entering valid username and password");
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("validusername"),PropertiesReader.readKey("validpassword"));
        DashBoardPage dashBoardPage  = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUser();

        logger.info("Asserting the name after logging into dashboard");
        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("dashboardmessage"));


    }

    @Owner("POOJASHREE")
    @Description("Verify the failed positive testcase")
    @Test
    public void testLoginFailedPositiveVWO() {

        logger.info("ChromeDriver initialized");
        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        logger.info("Entering valid username and password");
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("validusername"),PropertiesReader.readKey("validpassword"));
        DashBoardPage dashBoardPage  = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUser();

        logger.info("Asserting the name after logging into dashboard");
        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Poojashree");


    }
}

