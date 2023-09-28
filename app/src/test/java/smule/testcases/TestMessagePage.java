package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.HomePage;
import smule.pageobjects.LoginPage;
import smule.pageobjects.MessagePage;

public class TestMessagePage extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    MessagePage messagePage;
    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        quitDriver();
    }

    @Test
    public void shouldGoToMessagePage() throws InterruptedException {
        loginPage = new LoginPage();
        homePage = loginPage.goToHomePage();
        messagePage = homePage.navigateToMessagePage();
        String msg = messagePage.getTextFromMessagePage();
        Assert.assertEquals(msg, "Inbox", "Message isn't matching!!");
    }
}
