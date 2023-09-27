package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;

public class HomePage extends BaseClass {
    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.smule.singandroid:id/pre_search_title_text_view")
    public WebElement searchBox;

    public boolean isSearchBarVisible(){
        return searchBox.isDisplayed();
    }

}
