package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class TablePage extends BasePage {

    public TablePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    // Define elements locators and its method inside a table > Order screen > Right side
    public String orderHandlingMenuSendFirstCourseOptionId = "order_send_specific";
    public void selectSendFirstCourse(){click(By.id(orderHandlingMenuSendFirstCourseOptionId));}

    public String orderHandlingMenuSaveOptionId = "order_save_without_send";
    public void selectSaveBillInTable(){click(By.id(orderHandlingMenuSaveOptionId));}

    public String orderHandlingMenuSendNoPrintOptionId = "order_save_no_print";
    public void selectSendNoPrint(){click(By.id(orderHandlingMenuSendNoPrintOptionId));}

    public String orderHandlingMenuCancelOptionId = "order_cancel_exit";
    public void selectCancelBillInTable(){click(By.id(orderHandlingMenuCancelOptionId));}

    // Discard order changes?/ exit from the order?(select device's back key when nothing case) confirmation screen
    public String exitButtonId = "comanda_exit";
    public void selectExitButton(){click(By.id(exitButtonId));}

    public void selectSendOrderButton(){
        int exitButtonX = driver.findElement(By.id(exitButtonId)).getLocation().getX();
        int exitButtonWidth = driver.findElement(By.id(exitButtonId)).getSize().getWidth();
        int exitButtonY = driver.findElement(By.id(exitButtonId)).getLocation().getY();
        int exitButtonHeight = driver.findElement(By.id(exitButtonId)).getSize().getHeight();
        int pointX = exitButtonX - exitButtonWidth/2;
        int pointY = exitButtonY + exitButtonHeight/2;
        tapOnPoint(pointX,pointY);
    }

    public String exitConfirmationExitButtonId = "comanda_exit_ok";
    public void selectConfirmationExitButton(){click(By.id(exitConfirmationExitButtonId));}

    public String exitConfirmationCancelButtonId = "comanda_exit_cancel";
    public String exitConfirmationDisplayMessageId = "comanda_exit_text";// "Discard order changes?" or "exit from the order?"

    public String orderScreenRightSideBillDisplayId = "comandaListPager";

    // Define elements locators and its method inside a table > Order screen > Left side

    public String orderScreenLeftSideProductGridId = "pos_product_grid";
    public String orderScreenLeftSideCurrentPriceListDisplayId = "spinnerTarget";
    public String getCurrentPriceListInUse(){
        return readText(By.id(orderScreenLeftSideCurrentPriceListDisplayId));
    }
    public String orderScreenLeftSidePriceListMenuOptionId = "spinner_listino";
    public void selectPriceListMenuOption (){click(By.id(orderScreenLeftSidePriceListMenuOptionId));}

    // Define elements locators and its method inside a table > Payment screen > Right side

    public String paymentScreenLeftViewId = "comandaLeftPager";
    public String paymentScreenSplitOptionId = "dividi";
    public void selectSplitOption (){click(By.id(paymentScreenSplitOptionId));}

    public String paymentScreenPerPersonOptionId = "pro_capite_btn";
    public void selectPerPersonOption (){click(By.id(paymentScreenPerPersonOptionId));}

    public String paymentScreenPrebillOptionId = "stampa_preconto";
    public void selectPrebillOption (){click(By.id(paymentScreenPrebillOptionId));}

    public String paymentScreenBillOptionId = "paga_conto";
    public void selectBillOption(){click(By.id(paymentScreenBillOptionId));}


    public String paymentScreenChangeOptionId = "resto_btn";
    public void selectChangeOption(){click(By.id(paymentScreenChangeOptionId));}

    public String paymentScreenDeleteOptionId = "close_count";
    public void selectDeleteOption(){click(By.id(paymentScreenDeleteOptionId));}

    // Define elements locators and its method of alert has title Bill load confirmation screen

    public String billConfirmationScreenYesButtonId = "button1";
    public void selectYesBillConfirmation(){click(By.id(billConfirmationScreenYesButtonId));}

    public String billConfirmationScreenYesButtonText = "YES";
    public String billConfirmationScreenNoButtonId = "button2";
    public String billConfirmationScreenNoButtonText = "NO";

    public String billConfirmationScreenSaveWithoutPrintButtonId = "button3";
    public String billConfirmationScreenSaveWithoutPrintButtonText = "Save without printing";
    public String billConfirmationScreenMessageContentId = "message";

    // Define elements locators and its method inside a table > Payment screen > Right side > Split bill
    public String splitedBillCashButtonId = "incassa";
    public String splitedBillMoveButtonID = "cambia_tavolo";
}
