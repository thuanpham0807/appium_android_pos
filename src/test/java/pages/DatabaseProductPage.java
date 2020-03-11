package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class DatabaseProductPage extends BasePage {

    ////element locators for Product feature
    public String newProductIconId = "new_product";//id
    public String saveButtonId = "newproduct_ok_button";//id
    public String enableCheckBoxId = "newproduct_enable_check";//id --> Default is checked
    public String backButtonId = "newproduct_back";//id
    public String newProductNameFieldId = "newproduct_name";//id
    public String productColorButtonId = "product_color_button";
    public String newProductCodeFieldId ="newproduct_code";//id
    public String newProductSecondDesFieldId = "newproduct_secondary_desc";//id
    public String newProductPrice1FieldId = "newproduct_cost1";//id
    public String newProductPrice2FieldId = "newproduct_cost2";//id
    public String newProductPrice3FieldId = "newproduct_cost3";//id
    public String newProductPrice4FieldId = "newproduct_cost4";//id

    public String addPortionButtonId = "add_product_size";//id
    public String portionDescriptionFieldId = "size_name";//id
    public String deletePortionButtonId = "remove_size";//id
    public String portionPrice1FieldId = "size_cost1";//id
    public String portionPrice2FieldId = "size_cost2";//id
    public String portionPrice3FieldId = "size_cost3";//id
    public String portionPrice4FieldId = "size_cost4";//id

    public String newProductTakeawayPrice = "newproduct_cost_takeaway";//id

    public String newProductShowVariantCheckboxId = "product_open_variant_chk";//id
    public String newProductShowSizeCheckboxId = "product_open_size_chk";//id
    public String newProductReturnableEmptyListOptionId = "returnable_spinner";
    public String newProductReturnablesListPlaceholderOptionId = "spinnerTarget";//id
    public String newProductReturnableDefaultPlaceholderText = "none";//name(text)

    public String saleByWeightOrQuantityMenuId = "product_measure_sale_spinner";//id
    public String saleByWeightOrQuantityPlaceHolderText = " –– ";//name (text)
    public String saleByKgUnitOptionText = "Kg";//name (text)
    public String saleByLUnitOptionText = "L";//name (text)
    public String saleByMUnitOptionText = "M";//name (text)

    // bar code insert
    public String product_Form_Barcode = "barcode_input_code";//id
    public String product_Form_Barcode_Ok_Btn = "barcode_insert_button";// id

    public DatabaseProductPage(AndroidDriver<AndroidElement> driver){
        super (driver);
    }

    // Product screen methods

    public void goToProductCreatingForm(){
        click(By.id(newProductIconId));
    }

    public void inputProductName(String text){
        writeText(By.id(newProductNameFieldId),text);
    }

    public void inputSecondaryDescription(String text){
        writeText(By.id(newProductSecondDesFieldId),text);
    }

    ////////Set prices /////////////////////////////////////

    public void inputValueOfPrice1(String value){ writeText(By.id(newProductPrice1FieldId),value); }
    public void inputValueOfPrice2(String value){
        writeText(By.id(newProductPrice2FieldId),value);
    }
    public void inputValueOfPrice3(String value){
        writeText(By.id(newProductPrice3FieldId),value);
    }
    public void inputValueOfPrice4(String value){ writeText(By.id(newProductPrice4FieldId),value); }


    /////////End of set prices////////////////////////////////////

    public void selectSaveButton(){
        click(By.id(saveButtonId));
    }

    public void updateProductCode(String code){

        clearText(By.id(newProductCodeFieldId));
        writeText(By.id(newProductCodeFieldId),code);
    }

    public void callCatgoriesMenuByExistedName(String existed_Category_Name){
        click(By.name(existed_Category_Name));
    }
    public void selectToUpdateByNewCategory(String update_Category_Name){
        click(By.name(update_Category_Name));
    }

    public void callVatMenuByExistedValueInField(String existed_Value_Of_Vat){
        click(By.name(existed_Value_Of_Vat));
    }
    public void selectToUpdateNewVatValue(String new_Value_Of_Vat){
        click(By.name(new_Value_Of_Vat));
    }

    public void inputProductSecondaryDescription(String secondDes){
        writeText(By.id(newProductSecondDesFieldId),secondDes);
    }

    ////Set portions prices/////////////////
    public void callPortionsAddingForm(){
            click(By.id(addPortionButtonId));
    }
    public void inputPortionDescription(String des){
        writeText(By.id(portionDescriptionFieldId),des);
    }
    public void inputPortionPrice1(String price){
        writeText(By.id(portionPrice1FieldId),price);
    }
    public void inputPortionPrice2(String price){
        writeText(By.id(portionPrice2FieldId),price);
    }
    public void inputPortionPrice3(String price){
        writeText(By.id(portionPrice2FieldId),price);
    }
    public void inputPortionPrice4(String price){
        writeText(By.id(portionPrice4FieldId),price);
    }

    public void inputTakeawayPrice(String text){
        writeText(By.id(newProductTakeawayPrice),text);
    }

    public void callSaleByWeightOrQuantityMenu(){
        click(By.id(saleByWeightOrQuantityMenuId));
    }
    public void selectAnOptionOfSaleByWeightOrQuantity(String optionName){
        click(By.name(optionName));
    }

    public void checkOnShowVariants(){

        click(By.id(newProductShowVariantCheckboxId));
    }

    public void checkOnShowSizes(){
        click(By.id(newProductShowSizeCheckboxId));
    }

    public void inputBarcode(String barcode){
        writeText(By.id(product_Form_Barcode),barcode);
    }
    public void pressBarcodeOkBtn(){
        click(By.id(product_Form_Barcode_Ok_Btn));
    }

    public void callReturnaleList(){
        click(By.id(newProductReturnablesListPlaceholderOptionId));
    }
    public void selectReturnableByName(String returnableName){
        click(By.name(returnableName));
    }
    public void uncheckProductEnableBox(){
        boolean isCheck = isChecked(By.id(enableCheckBoxId));
        if(isCheck == true) {
            click(By.id(enableCheckBoxId));
        }
    }
}
