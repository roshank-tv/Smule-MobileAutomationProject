package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.ExplorePage;
import smule.pageobjects.SongBookPage;
import smule.pageobjects.LoginPage;

public class TestExplorePage extends BaseClass {
    LoginPage loginPage;
    SongBookPage songBookPage;
    ExplorePage explorePage;

    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void shouldGotoExplorePage() throws InterruptedException {
        loginPage = new LoginPage();
        songBookPage = loginPage.goToSongBookPage();
        explorePage = songBookPage.navigateToExplorePage();
        String text = explorePage.getTextFromExplorePage();
        Assert.assertEquals(text, "Moments", "Text from Explore page is not matching!!");
    }
}
