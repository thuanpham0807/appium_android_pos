package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class DatabaseVariantPage extends BasePage {

    // Define elements locators space
    public String variantsTabId = "listino_main_varianti";// id
    public String variantAddNewButtonId = "new_variant";//id
    public String variantsSearchByTextFieldId = "listino_ricerca_variante";//id
    public String categoriesSearchByTextFieldId = "listino_ricerca_categoria";//id
    public String productsSearchByTextFieldId = "listino_ricerca_prodotto";//id

    // elements locators in Creating form
    public String creatingFormTitleText = "new modifier";//name(text)
    public String typeMinusOrPlusRadioButtonId = "variant_type_minus_plus";
    public String typeModifyRadioButtonId = "variant_type_modify";

    public String creatingFormSaveButtonId = "newvariant_ok_button";//id
    public String creatingFormCancelButtonId = "newvariant_cancel_button";//id
    public String variant_Form_Name = "newvariant_name";//id
    public String variant_Form_Code = "newvariant_code";//id
    public String variant_Form_Secondary_Description = "newvariant_secondary_name";//id

    public String price1PlusFieldId = "newvariant_cost_plus_1";//id
    public String price1MinusFieldId = "newvariant_cost_minus_1";//id
    public String variant_Form_Price2_Plus = "newvariant_cost_plus_2";//id
    public String variant_Form_Price2_Minus = "newvariant_cost_minus_2";//id
    public String variant_Form_Price3_Plus = "newvariant_cost_plus_3";//id
    public String variant_Form_Price3_Minus = "newvariant_cost_minus_3";//id
    public String variant_Form_Price4_Plus = "newvariant_cost_plus_4";//id
    public String variant_Form_Price4_Minus = "newvariant_cost_minus_4";//id

    public DatabaseVariantPage(AndroidDriver<AndroidElement> driver){
        super (driver);
    }

    public void goToVariantsTab(){
        click(By.id(variantsTabId));
    }

    public void goToVariantCreatingForm(){
        click(By.id(variantAddNewButtonId));
    }

    public void inputVariantName(String variantName){
        writeText(By.id(variant_Form_Name),variantName);
    }

    public void inputVariantCode(String variantCode){
        writeText(By.id(variant_Form_Code),variantCode);
    }

    public void inputSecondaryDescription(String secondDes){
        writeText(By.id(variant_Form_Secondary_Description),secondDes);
    }

    public void inputPirce1Plus(String price1Plus){
        writeText(By.id(price1PlusFieldId),price1Plus);
    }
    public void inputPirce1Minus(String price1Minus){
        writeText(By.id(price1MinusFieldId),price1Minus);
    }
    public void inputPirce2Plus(String price2Plus){
        writeText(By.id(variant_Form_Price2_Plus),price2Plus);
    }
    public void inputPirce2Minus(String price2Minus){
        writeText(By.id(variant_Form_Price2_Minus),price2Minus);
    }
    public void inputPirce3Plus(String price3Plus){
        writeText(By.id(variant_Form_Price3_Plus),price3Plus);
    }
    public void inputPirce3Minus(String price3Minus){
        writeText(By.id(variant_Form_Price3_Minus),price3Minus);
    }
    public void inputPirce4Plus(String price4Plus){
        writeText(By.id(variant_Form_Price4_Plus),price4Plus);
    }
    public void inputPirce4Minus(String price4Minus){
        writeText(By.id(variant_Form_Price4_Minus),price4Minus);
    }

    public void selectSaveButton(){
        click(By.id(creatingFormSaveButtonId));
    }
    public void selectCancelButton(){
        click(By.id(creatingFormCancelButtonId));
    }
}
