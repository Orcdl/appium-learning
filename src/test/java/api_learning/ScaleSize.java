package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.awt.*;

public class ScaleSize {

    //Implicit wait, Explicit wait

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try{
            //Navigate to form screen
            MobileElement navLoginScreenBtnElme = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElme.click();

            //Wait until user is on Forum screen
            WebDriverWait wait = new WebDriverWait(appiumDriver,10L);
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(MobileBy.xpath("new UiSelector().textContain(\"Form componen\")")));


            // Get mobile windows Size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            //Calculate touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 10 * screenHeight / 100;

            //Convert coordinate -> PointOption
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint,xEndPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(yStartPoint,yEndPoint);

            // Using TouchAction to swipe
            TouchAction touchAction = new TouchAction<>(appiumDriver);
            touchAction.press(startPoint).moveTo(endPoint).release().perform();
            touchAction.press(startPoint);
            touchAction.waitAction(new WaitOptions());
            touchAction.moveTo(endPoint);
            touchAction.release();
            touchAction.perform();

            // Find all matching Elements
            MobileElement usernameElem = appiumDriver.findElement(MobileBy.xpath("//androidandroid.widget.EditText"));
            usernameElem.sendKeys("teo@sth.com");

            //Debug purpose only
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(appiumDriver !=null) appiumDriver.quit();
    }
}
