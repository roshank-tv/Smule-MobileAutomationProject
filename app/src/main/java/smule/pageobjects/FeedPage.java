package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;

public class FeedPage extends BaseClass {
    public FeedPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Recommended for you']")
    private WebElement textFromFeedPage;

    public String getTextFromFeedPage() {
        return textFromFeedPage.getText();
    }


}
