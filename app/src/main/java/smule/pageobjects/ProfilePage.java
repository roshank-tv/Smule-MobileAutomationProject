package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;

public class ProfilePage extends BaseClass {
    @AndroidFindBy(id = "com.smule.singandroid:id/txt_username")
    private WebElement userName;

    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getUserNameFromProfilePage() {
        return userName.getText();
    }
}
