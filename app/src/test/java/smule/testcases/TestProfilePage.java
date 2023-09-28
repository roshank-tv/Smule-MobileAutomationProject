package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.HomePage;
import smule.pageobjects.LoginPage;
import smule.pageobjects.ProfilePage;

public class TestProfilePage extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;

    @BeforeMethod
    public void setUp() {
        getDriver();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void shouldGoToProfilePage() throws InterruptedException {
        loginPage = new LoginPage();
        homePage = loginPage.goToHomePage();
        profilePage = homePage.navigateToProfilePage();
        String userName = profilePage.getUserNameFromProfilePage();
        Assert.assertEquals(userName, "RoshanKumar2807", "Username is not matching!!");
    }
}
