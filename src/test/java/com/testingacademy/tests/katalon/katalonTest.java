package com.testingacademy.tests.katalon;

import com.testingacademy.pages.pageObjectModel.katalon.AppointmentPage;
import com.testingacademy.pages.pageObjectModel.katalon.LoginPage;
import com.testingacademy.pages.pageObjectModel.katalon.MakeAppointPage;
import com.testingacademy.pages.pageObjectModel.katalon.VerificationPage;
import com.testingacademy.pages.pageObjectModel.vwo.DashBoardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class katalonTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    @Description("Verify makeappointment page for Katalon website ")
    @Test
    public void testMakeAppointment() {
        MakeAppointPage ma = new MakeAppointPage(driver);
        Assert.assertEquals(ma.makeAppointmentValidation(), "Please login to make appointment.");


    }


    @Description("Verify Login page for Katalon website ")
    @Test
    public void testLoginPage() {
        testMakeAppointment();
        LoginPage ds = new LoginPage(driver);
        ds.loginPageValidation("John Doe", "ThisIsNotAPassword");
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
    }


    @Description("Verify Appointment page for Katalon website ")
    @Test
    public void testAppointmentPage() {
        testLoginPage();
        AppointmentPage ap = new AppointmentPage(driver);
        Assert.assertEquals(ap.appointmentValidation(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

    }


    @Description("Verification page for Katalon website ")
    @Test
    public void test04_AppointmentPage() {
        testAppointmentPage();
        VerificationPage vp = new VerificationPage(driver);
        Assert.assertEquals(vp.verificationValidation(), "Appointment Confirmation");

    }

}

