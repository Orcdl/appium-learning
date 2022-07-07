package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Lesson_14 {

    public static void main(String[] args) {
        // Send a request into Appium server -> ask to launch the app
        AppiumDriver<MobileElement> appiumDriver = null;

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("automationName","uiautomator2");
        desiredCapabilities.setCapability("udid","153dc0950508");
        desiredCapabilities.setCapability("appPackage","com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");

        //Init appium session
        try {
            URL appiumSever = new URL("http://localhost:4723/wd/hub");
            appiumDriver = new AndroidDriver<MobileElement>(appiumSever, desiredCapabilities);
            System.out.println("Chạy tới đây là đúng nhen");
            //Debug purpose only
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if(appiumDriver !=null) appiumDriver.quit();

    }
}
