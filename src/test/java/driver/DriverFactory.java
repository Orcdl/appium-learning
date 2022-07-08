package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import platform.Platform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityEx {

    public static AppiumDriver<MobileElement> getDriver(Platform platform){
        AppiumDriver<MobileElement> appiumDriver = null;
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(PLATFORM_NAME,"Android");
            desiredCapabilities.setCapability(AUTOMATION_NAME,"uiautomator2");
            desiredCapabilities.setCapability(UDID,"153dc0950508");
            desiredCapabilities.setCapability(APP_PACKAGE,"com.wdiodemoapp");
            desiredCapabilities.setCapability(APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
            URL appiumSever = null;
        try{
            appiumSever = new URL("http://localhost:4723/wd/hub");

        }catch (Exception e){
            e.printStackTrace();
        }
        if(appiumSever == null)
            throw new RuntimeException("Can't construct the appium server url http://localhost:4723/wd/hub ");

        switch (platform){
            case ANDROID:
                appiumDriver = new AndroidDriver<MobileElement>(appiumSever, desiredCapabilities);
                break;
            case IOS:
                appiumDriver = new IOSDriver<MobileElement>(appiumSever, desiredCapabilities);
                break;
        }

        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return appiumDriver;



    }
}
