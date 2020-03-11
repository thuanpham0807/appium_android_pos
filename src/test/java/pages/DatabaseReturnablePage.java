package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class DatabaseReturnablePage extends BasePage {

    // Define elements locators space
    public String returnable_Tab = "listino_pfund";//id
    public String returnable_Text_Search_Btn =  "search_btn";//id
    public String returnable_Create_New_Btn = "new_pfand";//id
    public String returnable_Form_Save_Btn = "newpfand_ok_button";//id
    public String returnable_Form_Cancel_Btn = "newpfand_cancel_button";//id
    public String returnable_Form_Name = "newpfand_name";//id
    public String returnable_From_Secondary_Description = "pfand_secondary_name";//id
    public String returnable_Form_Price1 = "newpfand_cost1";//id
    public String returnable_Form_Price2 = "newpfand_cost2";//id
    public String returnable_Form_Price3 = "newpfand_cost3";//id
    public String returnable_Form_Price4 = "newpfand_cost4";//id
    public String returnable_Form_Code = "newpfand_code";//id


    public String returnable_Form_Vat_Default_Option = "  --  ";//text (name)
    public String vat_Menu_Option_2 = "10.00%";//text (name)
    public String vat_Nenu_Option_1 = "VAT free";//text (name)
    public String vat_Menu_Option_3 = "22.00%";//text (name)
    public String[] vat_List = new String[]{vat_Nenu_Option_1,vat_Menu_Option_2,vat_Menu_Option_3};



    public DatabaseReturnablePage(AndroidDriver<AndroidElement> driver){
        super (driver);
    }

    public void goToReturnableTab(){
        click(By.id(returnable_Tab));
    }

    public void goToReturnableCreatingForm(){
        click(By.id(returnable_Create_New_Btn));
    }

    public void inputReturnableName(String returnable_Name){
        writeText(By.id(returnable_Form_Name),returnable_Name);
    }

    public void inputReturnableSecondaryDescription(String second_Des){
        writeText(By.id(returnable_From_Secondary_Description),second_Des);
    }

    public void inputReturnablePrice1(String price1_Value){
        writeText(By.id(returnable_Form_Price1),price1_Value);
    }

    public void inputReturnablePrice2(String price2_Value){
        writeText(By.id(returnable_Form_Price2),price2_Value);
    }

    public void inputReturnablePrice3(String price3_Value){
        writeText(By.id(returnable_Form_Price3),price3_Value);
    }

    public void inputReturnablePrice4(String price4_Value){
        writeText(By.id(returnable_Form_Price4),price4_Value);
    }

    public void inputReturnableCode(String returnable_code){
        writeText(By.id(returnable_Form_Code),returnable_code);
    }

    public void selectSaveButton(){
        click(By.id(returnable_Form_Save_Btn));
    }

    public void selectCancelButton(){
        click(By.id(returnable_Form_Cancel_Btn));
    }

    public void callTaxMenu(){
        click(By.name(returnable_Form_Vat_Default_Option));
    }
    public void selectVatOption(String vat_Value){
        click(By.name(vat_Value));
    }

}
