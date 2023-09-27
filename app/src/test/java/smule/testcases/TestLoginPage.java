package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.HomePage;
import smule.pageobjects.LoginPage;

public class TestLoginPage extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void shouldGoToHomePage() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.selectLanguage();
        homePage = loginPage.goToHomePage();
        Assert.assertTrue(homePage.isSearchBarVisible());
    }
}
