package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;

public class SearchPage extends BaseClass {
    @AndroidFindBy(id = "com.smule.singandroid:id/trending_header_title")
    private WebElement trendingHeaderTitle;

    public SearchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getTextFromSearchPage() {
        return trendingHeaderTitle.getText();
    }
}
