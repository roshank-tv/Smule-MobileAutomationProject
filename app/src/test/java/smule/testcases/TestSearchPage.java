package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.SongBookPage;
import smule.pageobjects.LoginPage;
import smule.pageobjects.SearchPage;

public class TestSearchPage extends BaseClass {
    LoginPage loginPage;
    SongBookPage songBookPage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void shouldGoToSearchPage() throws InterruptedException {
        loginPage = new LoginPage();
        songBookPage = loginPage.goToSongBookPage();
        searchPage = songBookPage.navigateToSearchPage();
        String text = searchPage.getTextFromSearchPage();
        Assert.assertEquals(text, "Trending", "Text from Search Page is not matching!!");
    }

    @Test
    public void shouldSearchSongs() throws InterruptedException {
        loginPage = new LoginPage();
        songBookPage = loginPage.goToSongBookPage();
        searchPage = songBookPage.navigateToSearchPage();
        boolean result = searchPage.searchSong("Heeriye");
        Assert.assertTrue(result, "Songs list is not displayed!!");
    }
}
