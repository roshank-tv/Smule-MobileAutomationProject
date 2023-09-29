package smule.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import smule.base.BaseClass;

import java.time.Duration;

public class MessagePage extends BaseClass {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Inbox']")
    private WebElement inboxButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/chats_list")
    private WebElement chatList;

    @AndroidFindBy(id = "com.smule.singandroid:id/start_new_chat_icon")
    private WebElement newChatButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/search_edit_text")
    private WebElement searchTextBox;

    @AndroidFindBy(id = "com.smule.singandroid:id/chat_title")
    private WebElement chatTitle;

    @AndroidFindBy(id = "com.smule.singandroid:id/new_chat_forward_chat")
    private WebElement forwardChatButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/inputBox")
    private WebElement inputBox;

    @AndroidFindBy(id = "com.smule.singandroid:id/send_button")
    private WebElement sendButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hii']")
    private WebElement sentMessage;

    public MessagePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String sendMessage(String userName, String msg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(inboxButton));
        wait.until(ExpectedConditions.visibilityOf(chatList));
        newChatButton.click();
        searchTextBox.sendKeys(userName);
        chatTitle.click();
        forwardChatButton.click();
        inputBox.sendKeys(msg);
        sendButton.click();
        return sentMessage.getText();
    }
}
