package scenarios;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidSetup {
    public AndroidDriver<AndroidElement> driver;
    public AndroidDriver getDriver(){ return driver; }
    public void prepareAndroidForAppium(String apkFilePath) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Devices");
        //capabilities.setCapability("deviceName","182a61d4e6fd3cb7");

        // Copy and paste the apk file path(absolute path on your machine) that you want to test
        // we get apk file path for test from testsuite.xml file in tag <parameter>
        capabilities.setCapability("app", apkFilePath);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.embedia.pos");
        // Launch app by main activity
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.embedia.pos.Main");
        // block code for hide keyboard in during auto testing
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD,true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD,true);
        // END OF block code for hide keyboard in during auto testing

        //capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "appActivities");
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
