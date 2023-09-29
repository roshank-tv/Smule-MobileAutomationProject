package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.base.BaseClass;

import java.io.File;

public class SearchPage extends BaseClass {
    @AndroidFindBy(id = "com.smule.singandroid:id/trending_header_title")
    private WebElement trendingHeaderTitle;

    @AndroidFindBy(id = "com.smule.singandroid:id/search_edit_text")
    private WebElement searchBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='heeriye']")
    private WebElement searchResult;

    @AndroidFindBy(id = "com.smule.singandroid:id/search_showall_listview")
    private WebElement searchResultScreen;

    @AndroidFindBy(xpath = "com.smule.singandroid:id/search_mix_result_listview")
    private WebElement seeMixResultListView;

    private ITesseract tess;

    public SearchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.tess = new Tesseract();
        tess.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());
    }

    public String getTextFromSearchPage() {
        return trendingHeaderTitle.getText();
    }

    public boolean searchSong(String songName) {
        searchBox.sendKeys(songName);
        searchResult.click();
        return seeMixResultListView.isDisplayed();
    }

}