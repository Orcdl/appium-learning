package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.List;

public class XpathLearning {

    //Implicit wait, Explicit wait

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try{
            //Navigate to login screen
            MobileElement navLoginScreenBtnElme = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElme.click();

            // Find all matching Elements
            List<MobileElement> crediElem = appiumDriver.findElements(MobileBy.xpath("//androidandroid.widget.EditText"));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            crediElem.get(USERNAME_INDEX).sendKeys("teo@sth.com");
            crediElem.get(PASSWORD_INDEX).sendKeys("12345678");

            //Find Login info text by UISelector
            MobileElement loginInstructionELem = appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContain(\"When the device\")"));

            //Debug purpose only
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(appiumDriver !=null) appiumDriver.quit();
    }
}
