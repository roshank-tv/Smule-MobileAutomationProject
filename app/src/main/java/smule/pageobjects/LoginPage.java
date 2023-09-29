package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;
import smule.screenactions.ScreenActions;

public class LoginPage extends BaseClass {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='English' and @index='0']")
    private WebElement languageRadioButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/yesButton")
    private WebElement okButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/google_button_view")
    private WebElement signInWithGoogleButton;

    @AndroidFindBy(id = "com.google.android.gms:id/og_apd_internal_image_view")
    private WebElement googleDp;

    @AndroidFindBy(id = "com.smule.singandroid:id/noButton")
    private WebElement noButton;

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectLanguage() {
        ScreenActions.scrollToView("English");
        languageRadioButton.click();
        okButton.click();
    }

    public SongBookPage goToSongBookPage() throws InterruptedException {
        selectLanguage();
        signInWithGoogleButton.click();
        googleDp.click();
        noButton.click();
        return new SongBookPage();
    }
}