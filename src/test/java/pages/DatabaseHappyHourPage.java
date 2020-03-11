package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DatabaseHappyHourPage extends BasePage {

    // Define elements locators space
    public DatabaseHappyHourPage(AndroidDriver<AndroidElement> driver){
        super (driver);
    }
    // define element locators
    public String database_Happy_Hour_Tab = "happy hour";// text
    public String happy_Hour_Form_Add_New_Happy_Hour_Btn = "new_happy_hour_button";//id
    public String happy_Hour_Form_Add_New_Promotion_Btn = "new_happy_hour_promotion_button";//id
}