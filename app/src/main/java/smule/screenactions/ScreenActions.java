package smule.screenactions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import smule.base.BaseClass;

import java.time.Duration;

public class ScreenActions extends BaseClass {

    public static void scrollToView(String text){
        WebElement element = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\""+text+"\"))"));
    }

    public static void tap() {
        new TouchAction((PerformsTouchActions) driver).press(PointOption.point(1002, 375))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release()
                .perform();
    }
}
