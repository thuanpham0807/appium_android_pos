package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class ConfigurationOperatorsPage extends BasePage {

    // Define elements locators space
    public ConfigurationOperatorsPage(AndroidDriver<AndroidElement> driver){
        super (driver);
    }
    // common elements in page
    public String operatorTabName = "operators";
    public String operatorSectionId = "user_admin_operators";
    public String multiuserSectionId = "user_admin_operators";
    public String shiftsSectionId = "user_admin_timeshift";
    public String operatorSelectionListId = "users_list";
    public String addNewOperatorButtonId = "new_user";
    public String newOperatorScreenTitleId = "alertTitle";// get text ("new operator")
    public String newOperatorScreenNameFieldId = "newuser_name";
    public String newOperatorScreenOkButtonId = "button1";// get test ("OK")
    public String newOperatorScreenCancelButtonId = "button2";// get text ("cancel")
    public String operatorInfoDisplayNameLabelId = "toolbar_user_name";
    public String operatorInfoEditNameIconId = "edit_user_name";
    public String operatorInfoSaveOptionsButtonId = "save_user_options";
    public String operatorInfoDeleteButtonId = "delete_user";
    public String operatorCodeFieldId = "user_code";
    public String enableTrainingModeSwitchId = "sw_training_mode";

    // common methods
    public void selectOperatorsTab(){click(By.name(operatorTabName));}
    public void selectOperatorsSection(){ click(By.id(operatorSectionId));}
    public void selectAddNewOperatorButton (){ click(By.id(addNewOperatorButtonId)); }
    public void inputNewOperatorName(String name){ writeText(By.id(newOperatorScreenNameFieldId),name);}
    public void selectOkButton(){ click(By.id(newOperatorScreenOkButtonId));}
    public void selectCancelButton(){click(By.id(newOperatorScreenCancelButtonId));}
    public void selectAnOperatorByName(String operatorName){ click(By.name(operatorName));}
    public void selectSaveOptionsButton(){click(By.id(operatorInfoSaveOptionsButtonId));}

    public String getOperatorCode (){ return readText(By.id(operatorCodeFieldId));}


    public void updateNewOperatorCode(String newCode){
        click(By.id(operatorCodeFieldId));
        clearText(By.id(operatorCodeFieldId));
        writeText(By.id(operatorCodeFieldId),newCode);
    }
    // For Traning mode
    public void switchOnEnableTrainingModeOption(){
        boolean isSwitch = isSwitched(By.id(enableTrainingModeSwitchId));
        if(isSwitch == false){click(By.id(enableTrainingModeSwitchId));}
    }
    public void switchOffEnableTrainingModeOption(){
        boolean isSwitch = isSwitched(By.id(enableTrainingModeSwitchId));
        if(isSwitch == true){click(By.id(enableTrainingModeSwitchId));}
    }

    // For option "is allowed to close a bill"

    public String isAllowedToCloseABillSwitchId = "user_can_close_bill";
    public void switchOnIsAllowedToCloseABillOption(){
        boolean isSwitch = isSwitched(By.id(isAllowedToCloseABillSwitchId));
        if(isSwitch == false){click(By.id(isAllowedToCloseABillSwitchId));}
    }
    public void switchOffIsAllowedToCloseABillOption(){
        boolean isSwitch = isSwitched(By.id(isAllowedToCloseABillSwitchId));
        if(isSwitch == true){click(By.id(isAllowedToCloseABillSwitchId));}
    }
}
