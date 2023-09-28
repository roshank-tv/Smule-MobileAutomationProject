package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;

public class ActivityPage extends BaseClass {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Invites']")
    private WebElement invitesButton;
    public ActivityPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getTextFromInviteButton() {
        return invitesButton.getText();
    }
}
