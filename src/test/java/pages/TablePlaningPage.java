package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class TablePlaningPage extends BasePage {

    public TablePlaningPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    // Define elements locators
    public String tableGridViewId = "grid_table_id";
    public String backButtonId= "tavoli_back_button";
    //define Methods
    public void selectATableByName(String tableName){
        String xpath = "// android.widget.TextView[contains(@resource-id,'" + tableGridViewId + "')and @text='" + tableName + "']";
        click(By.xpath(xpath));
    }
    public void selectBackButton(){click(By.id(backButtonId));}

    public String restrictAccessTablesErrorMessageId = "custom_alert_message";// get text ("operator not allowed")
    public String restrictAccessTablesErrorScreenOkButtonId = "custom_alert_positive_button";
    public void selectRestrictAccessTablesErrorScreenOkButton(){click(By.id(restrictAccessTablesErrorScreenOkButtonId));}
    public String getErrorMessageText (){return readText(By.id(restrictAccessTablesErrorMessageId));}
}
