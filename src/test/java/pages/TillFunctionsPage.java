package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class TillFunctionsPage extends BasePage {

    public TillFunctionsPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    // Define elements locators
    public String closureOptionId = "funzioni_cassa_chiusura";
    public String dailyReportOptionId = "funzioni_cassa_lettura";
    public String dailyReportGlobalOptionId = "globale";
    public String drawerTotalInfoFieldId = "fondo_cassa";
    public String dailyClosingOptionId = "funzioni_cassa_chiusura";
    public String closeButtonId = "funzioni_cassa_close";
    //define Methods
    public void selectDailyReportOption (){click(By.id(dailyReportOptionId));}
    public void selectGlobalOption(){click(By.id(dailyReportGlobalOptionId));}
    public void selectClosureOption(){click(By.id(closureOptionId));}
    public String getDrawerTotalAmount (){return readText(By.id(drawerTotalInfoFieldId));}
    public void selectDailyClosingOption(){click(By.id(dailyClosingOptionId));}
    public void selectCloseButton(){click(By.id(closeButtonId));}
    // Define elements and menthods for closure action
    public String dailyClosureOptionId = "closure_type_1";
    public String weeklyClosureOptionId = "closure_type_2";
    public String monthlyClosureOptionId = "closure_type_3";
    public String yearlyClosureOptionId = "closure_type_4";
    public void selectDailyClosure (){click(By.id(dailyClosureOptionId));}
    public void selectWeeklyClosure(){click(By.id(weeklyClosureOptionId));}
    public void selectMonthlyClosure (){click(By.id(monthlyClosureOptionId));}
    public void selectYearlyClosure(){click(By.id(yearlyClosureOptionId));}
}
