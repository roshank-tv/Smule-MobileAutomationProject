package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.ActivityPage;
import smule.pageobjects.HomePage;
import smule.pageobjects.LoginPage;

public class TestActivityPage extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    ActivityPage activityPage;

    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void shouldGoToActivityPage() throws InterruptedException {
        loginPage = new LoginPage();
        homePage = loginPage.goToHomePage();
        activityPage = homePage.navigateToActivityPage();
        String text = activityPage.getTextFromInviteButton();
        Assert.assertEquals(text, "Invites", "Text is not matching!!");
    }
}
