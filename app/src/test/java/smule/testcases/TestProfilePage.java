package smule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.base.BaseClass;
import smule.pageobjects.FeedPage;
import smule.pageobjects.SongBookPage;
import smule.pageobjects.LoginPage;
import smule.pageobjects.ProfilePage;
import smule.utility.FakerClass;

public class TestProfilePage extends BaseClass {
    LoginPage loginPage;
    SongBookPage songBookPage;
    ProfilePage profilePage;
    FeedPage feedPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        getDriver();
        loginPage = new LoginPage();
        songBookPage = loginPage.goToSongBookPage();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void shouldGoToProfilePage() {
        profilePage = songBookPage.navigateToProfilePage();
        String userName = profilePage.getUserNameFromProfilePage();
        Assert.assertEquals(userName, "RoshanKumar2807", "Username is not matching!!");
    }

    @Test
    public void shouldUpdateProfile() {
        profilePage = songBookPage.navigateToProfilePage();
        String bio = FakerClass.generateBio();
        String result = profilePage.updateProfilePage(bio);
        Assert.assertEquals(result, bio, "Profile not updated!!");
    }

    @Test
    public void shouldBookMarkTheSong() {
        songBookPage.bookmarkTheSong();
        profilePage = songBookPage.navigateToProfilePage();
        boolean result = profilePage.navigateToAboutPage();
        Assert.assertTrue(result, "Song is not bookmarked!!");
    }

    @Test void shouldAddSongToPlaylist() {
        feedPage = songBookPage.navigateToFeedPage();
        feedPage.addSongToPlaylist();
        profilePage = songBookPage.navigateToProfilePage();
        String resultMessage = profilePage.navigateToPlaylist();
        Assert.assertNotEquals(resultMessage, "0 recordings", "Songs not added to Playlist!!");
    }

    @Test void shouldGoToInvitePage() {
        profilePage = songBookPage.navigateToProfilePage();
        String result = profilePage.navigateToInvites();
        Assert.assertEquals(result, "Invite your friends to join a collab!", "text is not matching from Invite Page!!");
    }
}