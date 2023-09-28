package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.FeedPage;
import smule.pageobjects.HomePage;
import smule.pageobjects.LoginPage;

public class TestFeedPage extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    FeedPage feedPage;
    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        quitDriver();
    }

    @Test
    public void shouldGoToFeedPage() throws InterruptedException {
        loginPage = new LoginPage();
        homePage = loginPage.goToHomePage();
        feedPage = homePage.navigateToFeedPage();
        String msg = feedPage.getTextFromFeedPage();
        Assert.assertEquals(msg, "Recommended for you", "Message isn't matching!!");
    }
}
