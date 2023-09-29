package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.ActivityPage;
import smule.pageobjects.SongBookPage;
import smule.pageobjects.LoginPage;

public class TestActivityPage extends BaseClass {
    LoginPage loginPage;
    SongBookPage songBookPage;
    ActivityPage activityPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        getDriver();
        loginPage = new LoginPage();
        songBookPage = loginPage.goToSongBookPage();
        activityPage = songBookPage.navigateToActivityPage();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void shouldGoToInvitePage() {
        boolean result = activityPage.navigateToInvitePage();
        Assert.assertTrue(result, "Join button in InvitePage is not enabled!!");
    }

    @Test
    public void shouldGoToNewsPage() {
        String text = activityPage.navigateToNewsPage();
        Assert.assertEquals(text, "No news from Smule yet", "Text from news page is not matching.");
    }

    @Test
    public void shouldGoToNotification() {
        boolean result = activityPage.navigateToNotificationPage();
        Assert.assertTrue(result, "list of notification is not displayed!!");
    }
}
