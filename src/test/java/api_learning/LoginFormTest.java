package api_learning;

import driver.DriverFactory;
import driver.MobileCapabilityEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

public class LoginFormTest {

    //Implicit wait, Explicit wait

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try{
            //Navigate to login screen
            MobileElement navLoginScreenBtnElme = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElme.click();

            //Find login form elements
            MobileElement emailInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passlInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement buttonLoginlInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            //Fill the form and login
            emailInputElem.sendKeys("teo@sth.com");
            passlInputElem.sendKeys("12345678");
            buttonLoginlInputElem.click();

            // Verification | Login dilog
            WebDriverWait wait = new WebDriverWait(appiumDriver,5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));

            MobileElement loginDialogTitleElem = appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println(loginDialogTitleElem.getText());


            //Debug purpose only
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(appiumDriver !=null) appiumDriver.quit();
    }
}
