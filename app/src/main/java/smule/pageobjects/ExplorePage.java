package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;

public class ExplorePage extends BaseClass {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Moments']")
    private WebElement textFromExplorePage;
    public ExplorePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getTextFromExplorePage() {
        return textFromExplorePage.getText();
    }
}