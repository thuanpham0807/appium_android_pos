package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class PriceListPage extends BasePage {

    public PriceListPage(AndroidDriver<AndroidElement> driver){
        super (driver);
    }

    // Define elements locators space
    String priceListScreen  = "listini_root";//id
    String priceListZeroCost = "set_listino_flat";//id (text is "zero cost")
    String priceList1 = "set_listino_1";//id (text is "price list 1")
    String priceList2 = "set_listino_2";//id (text is "price list 2")
    String priceList3 = "set_listino_3";//id (text is "price list 3")
    String priceList4 = "set_listino_1";//id (text is "price list 4")
    String titleCurrentPriceList = "current_pricelist";//id (text is "current price list: 1" with 1 is the price list is applied)
    // Define methods
    public void selectPriceListZero(){
        click(By.id(priceListZeroCost));
    }
    public void selectPriceList1(){
        click(By.id(priceList1));
    }
    public void selectPriceList2(){click(By.id(priceList2));}
    public void selectPriceList3(){click(By.id(priceList3));}
    public void selectPriceList4(){click(By.id(priceList4));}
    public boolean verifyPriceListZeroIsHidden(){
        return driver.findElementsByName(priceListZeroCost).size() != 0;
    }
}
