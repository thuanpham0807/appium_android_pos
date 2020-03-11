package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class DocumentsReceiptsPage extends BasePage {

    public DocumentsReceiptsPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    // Define elements locators
    public String receiptsOptionXpath = "//android.widget.TextView[@text= 'receipts' and @index = '1']";
    public String virtualBackButtonId = "reports_back_button";
    public String alwaysCheckBoxId = "checkBoxAlways";
    public String calculateButtonId = "report_calculate";
    public String receiptHistoryScreenId = "conto_storico_root";
    public String receiptHistoryScreenReprintIconId = "conto_storico_ristampa";
    //define Methods
    public void selectReceiptsOption(){click(By.xpath(receiptsOptionXpath));}
    public void selectCalculateButton(){click(By.id(calculateButtonId));}
    public void selectReprintIcon(){click(By.id(receiptHistoryScreenReprintIconId));}
    public void selectBackButton(){click(By.id(virtualBackButtonId));}
}
