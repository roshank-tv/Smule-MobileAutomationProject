package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.SongBookPage;
import smule.pageobjects.LoginPage;

public class TestLoginPage extends BaseClass {
    LoginPage loginPage;
    SongBookPage songBookPage;
    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void shouldGoToSongBookPage() throws InterruptedException {
        loginPage = new LoginPage();
        songBookPage = loginPage.goToSongBookPage();
        Assert.assertTrue(songBookPage.isSearchBarVisible());
    }
}
