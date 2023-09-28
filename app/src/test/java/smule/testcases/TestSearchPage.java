package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.HomePage;
import smule.pageobjects.LoginPage;
import smule.pageobjects.SearchPage;

public class TestSearchPage extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
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
        homePage = loginPage.goToHomePage();
        searchPage = homePage.navigateToSearchPage();
        String text = searchPage.getTextFromSearchPage();
        Assert.assertEquals(text, "Trending", "Text from Search Page is not matching!!");
    }
}
