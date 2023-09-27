package smule.pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;

public class LoginPage extends BaseClass {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='English' and @index='0']")
    public WebElement languageRadioButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/yesButton")
    public WebElement okButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/google_button_view")
    public WebElement signInWithGoogleButton;

    @AndroidFindBy(id = "com.google.android.gms:id/og_apd_internal_image_view")
    public WebElement googleDp;

    @AndroidFindBy(id = "com.smule.singandroid:id/noButton")
    public WebElement noButton;

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectLanguage() throws InterruptedException {
        scrollToView("Español");
        languageRadioButton.click();
        okButton.click();
    }

    public HomePage goToHomePage() {
        signInWithGoogleButton.click();
        googleDp.click();
        noButton.click();
        return new HomePage();
    }
    public void scrollToView(String text){
        WebElement element = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\""+text+"\"))"));
    }


}
