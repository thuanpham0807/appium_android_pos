package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class ConfigurationOtherPage extends BasePage {
    public ConfigurationOtherPage(AndroidDriver<AndroidElement> driver){
        super (driver);
    }

    // define common elements locators for other > settings
    public String otherFormSaveOptionsBtnId = "save_app_options";//id
    public String SettingsOptionsScrollViewId = "app_options_set";

    // Define elements locators for other > Settings > bill amount limit
    public String configurationOtherTabName = "other";//name (text)
    public String otherFormSettingsOptionId = "settings_options";//id
    public String settingsBillAmountLimitOptionId = "sezioneLimiteScontrino";
    public String settingsBillAmountLimitInputFieldId = "fiscal_printer_limit";//id

    ////methods  in configurations > other > settings > bill ampount limit
    public void selectBillAmountLimitInputField(){
        click(By.id(settingsBillAmountLimitInputFieldId));
    }
    public void inputValueOfBillAmountLimit(String value){
        writeText(By.id(settingsBillAmountLimitInputFieldId), value);
    }

    // define elements locators for other > settings > enable zero cost
    public String settingsEnableZeroCostOptionId = "sezioneFlatPrice";
    public String settingsEnableZeroCostSwitchId = "flat_price_value";//id

    ////methods  in configurations > other > settings > enable zero cost
    public void  switchYesEnableZeroCostOption(){
        boolean isSwitch = isSwitched(By.id(settingsEnableZeroCostSwitchId));
        System.out.print("get value of isSwitch" + isSwitch);
        if(isSwitch == false){
            click(By.id(settingsEnableZeroCostSwitchId));
        }
    }
    public void switchNoEnableZeroCostOption(){
        boolean isSwitch = isSwitched(By.id(settingsEnableZeroCostSwitchId));
        System.out.print("get value of isSwitch:" + isSwitch);
        if(isSwitch == true){
            click(By.id(settingsEnableZeroCostSwitchId));
        }
    }

    // define elements locators for other > settings > keypads in cents mode
    public String settingsKeypadsInCentsModeOptionId = "sezioneModoTastierini";//id
    public String settingsKeypadsInCentsModeSwitchId = "tastierini_centesimi";//id

    // define methods in Configurations > Other > Settings > keypads in cents mode
    public void switchYesKeypadsInCentsModeOption(){
        boolean isSwitch = isSwitched(By.id(settingsKeypadsInCentsModeSwitchId));
        if(isSwitch == false){click(By.id(settingsKeypadsInCentsModeSwitchId));}
    }
    public void switchNoKeypadsInCentsModeOption(){
        boolean isSwitch = isSwitched(By.id(settingsKeypadsInCentsModeSwitchId));
        if(isSwitch == true){click(By.id(settingsKeypadsInCentsModeSwitchId));}
    }

    // define elements locators for other > settings > reset price list after closing bill at front end
    public String settingsResetPriceListAfterClosingBillAtFrontEndOptionId = "sezioneRipristinoListinoFrontend";//id
    public String settingsResetPriceListAfterClosingBillAtFrontEndSwitchId = "ripristinaListinoFrontend";//id --> Default is YES
    ////methods  in configurations > other > settings > reset price list after closing bill at front end
    public void  switchYesResetPriceListAfterClosingBillAtFrontEndOption(){
        boolean isSwitch = isSwitched(By.id(settingsResetPriceListAfterClosingBillAtFrontEndSwitchId));
        System.out.print("get value of isSwitch" + isSwitch);
        if(isSwitch == false){
            click(By.id(settingsResetPriceListAfterClosingBillAtFrontEndSwitchId));
        }
    }
    public void switchNoResetPriceListAfterClosingBillAtFrontEndOption(){
        boolean isSwitch = isSwitched(By.id(settingsResetPriceListAfterClosingBillAtFrontEndSwitchId));
        System.out.print("get value of isSwitch:" + isSwitch);
        if(isSwitch == true){
            click(By.id(settingsResetPriceListAfterClosingBillAtFrontEndSwitchId));
        }
    }

    // define elements locators for other > settings > logout after bill
    public String settingsLogoutAfterBillOptionId = "sezioneLogout";
    public String settingsLogoutAfterBillSwitchId = "logout_after_bill";//id --> Default is NO
    ////methods  in configurations > other > settings > logout after bill
    public void  switchYesLogoutAfterBillOption(){
        boolean isSwitch = isSwitched(By.id(settingsLogoutAfterBillSwitchId));
        System.out.print("get value of isSwitch" + isSwitch);
        if(isSwitch == false){
            click(By.id(settingsLogoutAfterBillSwitchId));
        }
    }
    public void switchNoLogoutAfterBillOption(){
        boolean isSwitch = isSwitched(By.id(settingsLogoutAfterBillSwitchId));
        System.out.print("get value of isSwitch:" + isSwitch);
        if(isSwitch == true){
            click(By.id(settingsLogoutAfterBillSwitchId));
        }
    }

    // define elements locators for other > settings > enable drawer opening
    public String settingsEnableDrawerOpeningSwitchId = "abilita_apertura_cassetto";//id --> Default is YES

    ////methods  in configurations > other > settings > enable drawer opening
    public void  switchYesEnableDrawerOpeningOption(){
        boolean isSwitch = isSwitched(By.id(settingsEnableDrawerOpeningSwitchId));
        System.out.print("get value of isSwitch" + isSwitch);
        if(isSwitch == false){
            click(By.id(settingsEnableDrawerOpeningSwitchId));
        }
    }
    public void switchNoEnableDrawerOpeningOption(){
        boolean isSwitch = isSwitched(By.id(settingsEnableDrawerOpeningSwitchId));
        System.out.print("get value of isSwitch:" + isSwitch);
        if(isSwitch == true){
            click(By.id(settingsEnableDrawerOpeningSwitchId));
        }
    }

    // define elements locators for other > settings > reset price list after closing bill in table
    public String settingsResetPriceListAfterClosingBillInTableOptionId = "sezioneRipristinoComanda";
    public String settingsResetPriceListAfterClosingBillInTableSwitchId = "ripristinaListinoComanda";

    // Methods in Configurations > other > settings > reset price list after closing bill in table
    public void  switchYesResetPriceListAfterClosingBillInTableOption(){
        boolean isSwitch = isSwitched(By.id(settingsResetPriceListAfterClosingBillInTableSwitchId));
        System.out.print("get value of isSwitch" + isSwitch);
        if(isSwitch == false){
            click(By.id(settingsResetPriceListAfterClosingBillInTableSwitchId));
        }
    }
    public void switchNoResetPriceListAfterClosingBillInTableOption(){
        boolean isSwitch = isSwitched(By.id(settingsResetPriceListAfterClosingBillInTableSwitchId));
        System.out.print("get value of isSwitch:" + isSwitch);
        if(isSwitch == true){
            click(By.id(settingsResetPriceListAfterClosingBillInTableSwitchId));
        }
    }

    // define elements locators for other > settings > restrict access to tables
    public String settingsRestrictAccessToTablesOptionId = "sezione_resttrict_table";
    public String settingsRestrictAccessToTablesSwitchId = "restrict_table";

    // Methods in Configurations > other > settings > reset price list after closing bill in table
    public void  switchYesRestrictAccessToTablesOption(){
        boolean isSwitch = isSwitched(By.id(settingsRestrictAccessToTablesSwitchId));
        System.out.print("get value of isSwitch" + isSwitch);
        if(isSwitch == false){
            click(By.id(settingsRestrictAccessToTablesSwitchId));
        }
    }
    public void switchNoRestrictAccessToTablesOption(){
        boolean isSwitch = isSwitched(By.id(settingsRestrictAccessToTablesSwitchId));
        System.out.print("get value of isSwitch:" + isSwitch);
        if(isSwitch == true){
            click(By.id(settingsRestrictAccessToTablesSwitchId));
        }
    }

    // define elements locators for other > settings > empty drawer at daily closing
    public String settingsEmptyDrawerAtDailyClosingOptionId = "svuota_cassa_layout";
    public String settingsEmptyDrawerAtDailyClosingSwitchId = "svuota_cassa_switch";

    // Methods in other > settings > empty drawer at daily closing

    public void  switchYesEmptyDrawerAtDailyClosingOption(){
        boolean isSwitch = isSwitched(By.id(settingsEmptyDrawerAtDailyClosingSwitchId));
        System.out.print("get value of isSwitch" + isSwitch);
        if(isSwitch == false){
            click(By.id(settingsEmptyDrawerAtDailyClosingSwitchId));
        }
    }
    public void switchNoEmptyDrawerAtDailyClosingOption(){
        boolean isSwitch = isSwitched(By.id(settingsEmptyDrawerAtDailyClosingSwitchId));
        System.out.print("get value of isSwitch:" + isSwitch);
        if(isSwitch == true){
            click(By.id(settingsEmptyDrawerAtDailyClosingSwitchId));
        }
    }

    /////////////////////////////

    ////methods in Configurations > Other > settings
    public void goToOtherSection (){
        click(By.name(configurationOtherTabName)); }
    public void selectSettingsOption(){
        click(By.id(otherFormSettingsOptionId));
    }
    public void selectSaveOptionsButton(){
        click(By.id(otherFormSaveOptionsBtnId));
    }


}
