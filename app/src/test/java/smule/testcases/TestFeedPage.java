package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.FeedPage;
import smule.pageobjects.SongBookPage;
import smule.pageobjects.LoginPage;

public class TestFeedPage extends BaseClass {
    LoginPage loginPage;
    SongBookPage songBookPage;
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
    public void shouldPlayVideo() throws InterruptedException {
        loginPage = new LoginPage();
        songBookPage = loginPage.goToSongBookPage();
        feedPage = songBookPage.navigateToFeedPage();
        boolean result = feedPage.playVideoFromFeedPage();
        Assert.assertTrue(result, "Video is not playing!!");
    }
}
