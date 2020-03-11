package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class TechnicianCodeConfirmationPage extends BasePage {

    public TechnicianCodeConfirmationPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    // Define elements locators
    public String screenTitleId = "alertTitle";// text (Fiscale notice)
    public String displayMessageId = "popup_message";// text (Machine not fiscalized. Fiscalize now?)
    public String inputCodeFieldId = "popup_code";
    public String okButtonId = "button1";// text (OK)
    public String cancelButtonId = "button2";// text (cancel)
    public void selectOkButton(){click(By.id(okButtonId));}
    public void selectCancelButton(){click(By.id(cancelButtonId));}
    public void inputOperatorCode(String code){writeText(By.id(inputCodeFieldId),code);}
}
