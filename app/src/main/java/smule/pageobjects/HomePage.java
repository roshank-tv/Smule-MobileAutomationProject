package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;
import smule.screenactions.ScreenActions;

public class HomePage extends BaseClass {
    @AndroidFindBy(id = "com.smule.singandroid:id/pre_search_title_text_view")
    private WebElement searchBox;

    @AndroidFindBy(id = "com.smule.singandroid:id/messageIcon")
    private WebElement messageButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_profile")
    private WebElement profileButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_activity")
    private WebElement activityButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_explore")
    private WebElement exploreButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_feed")
    private WebElement feedButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_songbook")
    private WebElement songBookButton;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public boolean isSearchBarVisible(){
        return searchBox.isDisplayed();
    }

    public MessagePage navigateToMessagePage() {
        ScreenActions.tap();
        messageButton.click();
        return new MessagePage();
    }

    public FeedPage navigateToFeedPage() {
        ScreenActions.tap();
        feedButton.click();
        return new FeedPage();
    }

    public ExplorePage navigateToExplorePage() {
        ScreenActions.tap();
        exploreButton.click();
        return new ExplorePage();
    }

    public ActivityPage navigateToActivityPage() {
        ScreenActions.tap();
        activityButton.click();
        return new ActivityPage();
    }

    public ProfilePage navigateToProfilePage() {
        ScreenActions.tap();
        profileButton.click();
        return new ProfilePage();
    }

    public SearchPage navigateToSearchPage() {
        ScreenActions.tap();
        searchBox.click();
        return new SearchPage();
    }
}
