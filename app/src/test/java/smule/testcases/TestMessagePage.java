package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.SongBookPage;
import smule.pageobjects.LoginPage;
import smule.pageobjects.MessagePage;

public class TestMessagePage extends BaseClass {
    LoginPage loginPage;
    SongBookPage songBookPage;
    MessagePage messagePage;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        getDriver();
        loginPage = new LoginPage();
        songBookPage = loginPage.goToSongBookPage();
        messagePage = songBookPage.navigateToMessagePage();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        quitDriver();
    }

    @Test
    public void shouldSendMessage() {
        String userName = "kbaganna";
        String message = "Hii";
        String result = messagePage.sendMessage(userName, message);
        Assert.assertEquals(result, "Hii", "Message not sent!!");
    }
}