package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;

public class MessagePage extends BaseClass {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Inbox']")
    private WebElement inboxButton;

    public MessagePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getTextFromMessagePage() {
        return inboxButton.getText();
    }
}
