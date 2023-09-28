package smule.testcases;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.ExplorePage;
import smule.pageobjects.HomePage;
import smule.pageobjects.LoginPage;

public class TestExplorePage extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
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
        homePage = loginPage.goToHomePage();
        explorePage = homePage.navigateToExplorePage();
        String text = explorePage.getTextFromExplorePage();
        Assert.assertEquals(text, "Moments", "Text from Explore page is not matching!!");
    }
}
