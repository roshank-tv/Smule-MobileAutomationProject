package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;
import smule.screenactions.ScreenActions;

public class ActivityPage extends BaseClass {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Invites']")
    private WebElement invitesButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications']")
    private WebElement notificationButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='News']")
    private WebElement newsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No news from Smule yet']")
    private WebElement messageFromNewsPage;

    @AndroidFindBy(id = "com.smule.singandroid:id/notifications_listview")
    private WebElement notificationsList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Join']")
    private WebElement joinButtonOfInvitePage;

    public ActivityPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean navigateToInvitePage() {
        ScreenActions.tap();
        return joinButtonOfInvitePage.isEnabled();
    }

    public String navigateToNewsPage() {
        ScreenActions.tap();
        newsButton.click();
        return messageFromNewsPage.getText();
    }

    public boolean navigateToNotificationPage() {
        ScreenActions.tap();
        notificationButton.click();
        return notificationsList.isDisplayed();
    }
}
