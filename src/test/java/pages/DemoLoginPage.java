package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.By;


public class DemoLoginPage extends BasePage {

    public DemoLoginPage(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }

    public String key1 = "key1";//id
    public String key2 = "key2";//id
    public String key3 = "key3";//id
    public String key4 = "key4";
    public String keyCancel = "keyCanc";//id
    public String keyOK = "keyOk";//id


    public void clickOnKey1 (){
        click(By.id(key1));
    }
    public void clickOnkey2(){
        click(By.id(key2));
    }

}
