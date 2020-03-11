package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import utils.TestDataManagement.GeneralData;

public class ConfigurationPrintersPage extends BasePage {

    public ConfigurationPrintersPage(AndroidDriver<AndroidElement> driver){
        super (driver);
    }

    // Define elements locators space
    public String printerTab = "printers";// name (text)
    public String printerFromLanOption = "printer_type_ethernet";//id
    public String printerFormUsbOption = "printer_type_usb";//id
    public String printerFormRs232Option = "printer_type_serial";//id
    public String printerFormIpInputField = "printer_ip";//id
    public String printerFormSaveButton = "save_printer_options";//id
    public String printerFromDeleteButton = "delete_printer";//id
    public String printerFromPaperWidth = "printer_width";//id
    public String embeddedPrinterOptionId = "printer_type_serial";//using in Pax device model e 800
    //define Methods
    public void goToPrinterSection(){
        click(By.name(printerTab));
    }
    public void selectPrinter(String printerName){
        click(By.name(printerName));
    }
    public void selectPrinterType(String printerType){
        boolean isChecked = isChecked(By.id(printerType));
        if (isChecked == false){
            click(By.id(printerType));
        }
    }
    public void inputPrinterIp(String printerIp){
        writeText(By.id(printerFormIpInputField),printerIp);
    }
    public void selectSaveButton(){
        click(By.id(printerFormSaveButton));
    }
    public void selectPaxE800EmbeddedPrinter(){click(By.id(embeddedPrinterOptionId));}
}
