package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import utils.TestDataManagement.GeneralData;
import utils.TestDataManagement.Color;

public class DatabaseDepartmentPage extends BasePage {

    public String departmentPricelistTabName = "listino_main_listino";//id
    public String addNewDepartment = "new_category"; //id
    public String departmentFormSaveBtn = "newdept_button_ok"; //id
    public String departmentFormCancelBtn = "newdept_button_cancel"; //id
    public String departmentFormDescription = "newdept_name"; //id
    public String departmentFormSecondDescription = "newdept_secondary_name"; //id
    public String departmentFormCategory = "newdept_index";//id
    public String departmentFormParentCategoryPlaceholderText = "none";// text (name)
    public String departmentFormFatherCategorySpinnerId = "fatherCategorySpinner";
    public String departmentFormPrice = "newdept_price";//id
    public String departmentFormMaxPrice = "newdept_max_price";//id
    public String primaryPrinterLayoutId = "primary_cat_printer_layout";
    public String secondPrinterLayoutId = "secondary_cat_printer_layout";
    public String departmentFromPrinterAddIcon = "add_tag_btn";//id
    public String departmentFromSecondPrinter = "add_tag_btn";//id
    public String departmentFormShowVariants = "category_open_variant_chk";//id
    public String departmentFormTicketing = "category_ticketing";//id
    public String departmentFormVisible = "category_visible";//id
    public String departmentFormColorPallete = "dept_default_color";//id
    // define colors picker
    public String colorPickerColorgridId = "color_picker_color_grid";
    public String colorPickerDialogRootId = "color_picker_dialog_root";
    public String departmentFormImage = "category_bitmap";
    public String deparmentFormPrinterMenu = "item_selection_name";//id

    // element locators for print categories function
    public String departmentFormPrintCategoriesIcon = "print_list";//id
    public String printCategoriesFromSellectAll = "print_ch_kall";//id
    public String printCategoriesFromConfirmBtn  = "print_confirm";//id
    public String printcategoriesFromExportBtn = "export_selection";//id

    public String departmentFormVatConfigIcon = "vat_config";// id

    ////For VAT
    String departmentFormVatDefaultOption = "  --  ";//text (name)
    public String vatMenuOption2 = "10.00%";//text (name)
    public String vatNenuOption1 = "VAT free";//text (name)
    public String vatMenuOption3 = "22.00%";//text (name)




    public DatabaseDepartmentPage (AndroidDriver<AndroidElement> driver){
        super (driver);
    }

    // Department screen methods

    public void goToDepartmentCreatingForm(){

        click(By.id(addNewDepartment));
    }
    // methods of Department Name text-field
    public void inputDepartmentName (String departmentName){
        writeText(By.id(departmentFormDescription),departmentName);
    }
    public void clearDepartmentName (){
        clearText(By.id(departmentFormDescription));
    }

    public void inputSecondaryDescription(String secondDes){
        writeText(By.id(departmentFormSecondDescription),secondDes);
    }
    public void clearSecondaryDescription(){
        clearText(By.id(departmentFormSecondDescription));
    }

    // Select a category to become parent
    public void callParentCategoriesMenu(){
        click(By.name(departmentFormParentCategoryPlaceholderText));
    }

    public void selectAValidParentByName(String parentName){
        click(By.name(parentName));
    }

    // Select values in VAT fields no 1, 2, 3
    public void showVATMenu (String displayOption){
        click(By.name(displayOption));
    }
    public void selectValueForVAT(String vatoptions){
        click(By.name(vatoptions));
    }

    public void selectSaveButton(){

        click(By.id(departmentFormSaveBtn));
    }
    public void selectCancelButton(){
        click(By.id(departmentFormCancelBtn));
    }
    //Start of block code "Select the elements have NAF = True by screen's location"
    /*
    click on the Toggle NAF Nodes button to see UI components that are not accessible to the uiautomator testing
    framework. Only limited information may be available for these components.
    Reference links:
    https://stuff.mit.edu/afs/sipb/project/android/docs/tools/testing/testingui.html
    https://innovatube.github.io/android-automation-test/#12
     */
    public void callPrintersMenu(){
        int locationX = driver.findElement(By.id(primaryPrinterLayoutId)).getLocation().getX();
        int locationY = driver.findElement(By.id(primaryPrinterLayoutId)).getLocation().getY();
        int height = driver.findElement(By.id(primaryPrinterLayoutId)).getSize().getHeight();
        int width = driver.findElement(By.id(primaryPrinterLayoutId)).getSize().getWidth();
        int pointX = (int)(locationX + width*0.96);
        int pointY = (locationY + height / 2);
        tapOnPoint(pointX,pointY); // this is the location of point to tap on Device screen
    }

    public void callSecondPrinterMenu(){
        int locationX = driver.findElement(By.id(secondPrinterLayoutId)).getLocation().getX();
        int locationY = driver.findElement(By.id(secondPrinterLayoutId)).getLocation().getY();
        int height = driver.findElement(By.id(secondPrinterLayoutId)).getSize().getHeight();
        int width = driver.findElement(By.id(secondPrinterLayoutId)).getSize().getWidth();
        int pointX = (int)(locationX + width*0.96);
        int pointY = (locationY + height / 2);
        tapOnPoint(pointX,pointY); // this is the location of point to tap on Device screen
    }

    public void callColorPallete (){
        click(By.id(departmentFormColorPallete));
    }
    public void pickAColorByLocation(int x, int y){
        tapOnPoint(x,y);
    }


    //End of block code "Select the elements have NAF = True by screen's location"

    public void selectPrintList (){
        click(By.id(departmentFormPrintCategoriesIcon));
    }
    public void selectVatConfig(){
        click(By.id(departmentFormVatConfigIcon));
    }

    public void checkShowVariants(){
        boolean isCheck = isChecked(By.id(departmentFormShowVariants));
        if(isCheck == false){click(By.id(departmentFormShowVariants));}
    }
    public void uncheckShowVariants(){
        boolean isCheck = isChecked(By.id(departmentFormShowVariants));
        if(isCheck == true){click(By.id(departmentFormShowVariants));}
    }

    public void checkTicketing(){
        boolean isCheck = isChecked(By.id(departmentFormTicketing));
        if(isCheck == false){click(By.id(departmentFormTicketing));}
    }
    public void uncheckTicketing(){
        boolean isCheck = isChecked(By.id(departmentFormTicketing));
        if(isCheck == true){click(By.id(departmentFormTicketing));}
    }

    public void selectPrinter(String printerName){
        waitForClickabilityOf(By.id(deparmentFormPrinterMenu));
        click(By.name(printerName));
    }

    public void inputPriceValue(String priceValue){
        writeText(By.id(departmentFormPrice),priceValue);
    }
    public void clearPriceValue(){
        clearText(By.id(departmentFormPrice));
    }

    public void inputMaxPriceValue(String maxPriceValue){
        writeText(By.id(departmentFormMaxPrice),maxPriceValue);
    }
    public void clearMaxPriceValue(){
        clearText(By.id(departmentFormMaxPrice));
    }

    public void clearCategoryValue(){
        clearText(By.id(departmentFormCategory));
    }
    public void inputCategoryValue(String categoryId){
        writeText(By.id(departmentFormCategory),categoryId);
    }

    public void selectDepartment(String departmentName){
        click(By.name(departmentName));
        isSelected(By.name(departmentName));
    }

    public void callCategoriesListToPrint (){
        click(By.id(departmentFormPrintCategoriesIcon));
    }
    public void selectAllCategoriesToBePrinted(){
        click(By.id(printCategoriesFromSellectAll));
    }
    public void selectSpecificCategoriesToBePrinted (String categoriesNameToPrint){
        click(By.name(categoriesNameToPrint));
    }

    public void uncheckVisible(){
        boolean isCheck = isChecked(By.id(departmentFormVisible));
        if(isCheck == true){click(By.id(departmentFormVisible));}
    }

    public void checkVisible(){
            boolean isCheck = isChecked(By.id(departmentFormVisible));
            if(isCheck == false){click(By.id(departmentFormVisible));}
    }

    public void selectPricelistTab(){
        click(By.id(departmentPricelistTabName));
    }

}
