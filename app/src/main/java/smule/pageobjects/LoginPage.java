package smule.pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;

public class LoginPage extends BaseClass {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='English' and @index='0']")
    private WebElement languageRadioButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/yesButton")
    private WebElement okButton;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public void selectLanguage() throws InterruptedException {
        Thread.sleep(10000);
        scrollToView("Español");
        languageRadioButton.click();
        okButton.click();
    }

    public void scrollToView(String text){
        WebElement element = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\""+text+"\"))"));
    }
}
