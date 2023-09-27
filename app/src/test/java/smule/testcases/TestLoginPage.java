package smule.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.LoginPage;

public class TestLoginPage extends BaseClass {
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void testingLanguageSelection() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.selectLanguage();
    }
}
