package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public HomePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /// element locators define
    /// Options list menu
    public String optionsButton = "pos_toolbar_settings_button";//id
    public String optionsMenu = "tv_title";//id
    public String optionsDatabases = "databases";//name(text)
    public String optionsConfiguration = "configuration";//name(text)
    public String optionsStats = "stats";//name(text)
    public String optionsDocuments = "documents";//name(text)
    public String optionsPriceList = "price list";//name(text)
    public String optionsWarehouseUtilities = "warehouse utilities";//name(text)
    public String optionsTillFunctionsName = "Till functions";//name(text)
    public String optionsLog = "log";//name(text)
    public String optionsLockId = "lock";//name(text)
    public void selectLockOption (){click(By.id(optionsLockId));}
    public void selectTillFunctionsOption (){click(By.name(optionsTillFunctionsName));}
    public void selectDocumentsOption(){click(By.name(optionsDocuments));}

    /// Methods for Options list menu
    public void selectPriceListSection(){
        click(By.name(optionsPriceList));
    }

    ////// Departments column
    public String departmentDropdownMenuRefillReportOption = "refill report";//name (text)
    public String departmentDropdownMenuNoRefillReportOption = "no refill report";// name (text)

    //////Operative feature access area
    public String homeTablesTab = "pos_toolbar_tavoli_button";//id
    //Method to open table tab
    public void selectTablesTab (){
        click(By.id(homeTablesTab));
    }

    public String homeParkTab = "pos_toolbar_customer_button";//id
    public String homeFeedTab = "pos_toolbar_feed_button";//id
    public String homeDrawerTab = "pos_toolbar_cassetto_button";//id

    //Sale Management Area
    //////Command bar
    public String homeCommandbarBarcodeSearchBtn = "barcode_search";//id and it's image button
    public String homeCommandbarTextSearchBtn = "search_btn";//id and it's image button
    public String homeCommandbarFontsizeBtn = "sel_fontsize";//id and it's image button
    ////////////Font Size config menu | elements point locations
    int[] fontsizeMenuCategoriesOption = new int[]{525, 345};
    int[] fontsizeMenuProductsOption = new int[]{640, 345};
    int[] fontsizeMenuBillOption = new int[]{755, 345};
    int[] fontsizeMenuPlusBtn = new int[]{485, 410};
    int[] fontsizeMenuMinusBtn = new int[]{540, 410};
    int[] fontsizeMenuRefreshBtn = new int[]{600, 410};
    //////Product area
    public String productDropMenuDisableOption = "disable";//name (text)
    public String productDropMenuEditOption = "edit";//name (text)
    public String productDropMenuAssociateToTheNewStock = "associate to the new stock";//name (text)
    public String productDropMenuRefillReport = "refill report";//name (text)
    public String productDropMenuNoRefillReport = "no refill report";//name (text)
    //////Command bar
    public String homeCommandbarFavoritelistBtn = "sel_star";//id and it's image button
    ///////////Add Favorite function
    public String homeFavoriteAddBtn = "pos_favorites_add_one";//id
    public String homeFavoriteConfigFormOkBtn = "button1";//id
    public String homeFavoriteConfigFormCancelBtn = "button2";//id
    public String homeFavoriteConfigFormNameField = "favorites";//name(text) this is place holder text need check for sure can call method sendtext() in it

    public String homeCommandbarEditBtn = "sel_edit";//id and it's image button
    public String homeCommandbarListviewIcon = "sel_list";//id and it's image button and default display
    public String homeCommandbarGridviewIcon = "sel_grid";//id and it's image button

    /////////On-Screen keyboard
    public String homeCommandbarOnOffScreenKeyboardBtn = "sel_kpad";//id
    public String homeOnScreenKeyboardKey0 = "key0";//id
    public String homeOnScreenKeyboardKey1 = "key1";//id
    public String homeOnScreenKeyboardKey2 = "key2";//id
    public String homeOnScreenKeyboardKey3 = "key3";//id
    public String homeOnScreenKeyboardKey4 = "key4";//id
    public String homeOnScreenKeyboardKey5 = "key5";//id
    public String homeOnScreenKeyboardKey6 = "key6";//id
    public String homeOnScreenKeyboardKey7 = "key7";//id
    public String homeOnScreenKeyboardKey8 = "key8";//id
    public String homeOnScreenKeyboardKey9 = "key9";//id
    public String homeOnScreenKeyboardKey00 = "key00";//id
    public String homeOnScreenKeyboardKeyDot = "keyDot";//id
    public String homeOnScreenKeyboardKeyC = "keyC";//id
    public String homeOnScreenKeyboardKeyPercentMinus = "keyPercentMinus";//id
    public String homeOnScreenKeyboardKeyPercentPlus = "keyPercentPlus";//id
    public String homeOnScreenKeyboardKeyX = "keyX";//id
    public String homeOnScreenKeyboardKeyServiceCharge = "pos_service_charge";///id
    public String homeOnScreenKeyboardKeyReprintLastBill = "pos_ristampa_scontrino";//id
    public String homeOnScreenKeyboardKeyWithdrawal = "pos_prelievo";//id
    public String homeOnScreenKeyboardKeyCustomer = "pos_customer_select";//id
    public String homeOnScreenKeyboardKeyReturned = "pos_reso";//id
    public String homeOnScreenKeyboardKeyDeposit = "pos_deposito";//id
    public String homeOnScreenKeyboardKeyReturnable = "pos_returnable";//id
    public String homeOnScreenKeyboardKeyPLU = "pos_plu_select";//id
    public String homeOnScreenKeyboardKeyRebate = "pos_abbuono";//id

    ////Operator Display Area
    public String homeOperatorDisplayAreaPriceListDisplayBox = "pos_info_listino";//id
    public String getCurrentPriceListInUse(){
        return readText(By.id(homeOperatorDisplayAreaPriceListDisplayBox));
    }
    public String homeOperatorDisplayAreaTotalBtn = "pos_totale_conto_button";//id
    public String homeOperatorDisplayAreaSubTotalBtn = "pos_subtotale_button";//id
    public String homeOperatorDisplayAreaCancelBillBtn = "pos_cancel_conto_button";//id
    public String homeOperatorDisplayAreaInputedPriceInfoDisplay = "pos_info_parziale";//id
    public String operatorDisplayInfoHeaderId = "pos_info_header_operator";//id
    public String getLoginInfoHeader()
    {
        System.out.print(readText(By.id(operatorDisplayInfoHeaderId)) + "\n");
        return readText(By.id(operatorDisplayInfoHeaderId));
    }

    public void selectOperatorDisplayCancelButton(){click(By.id(homeOperatorDisplayAreaCancelBillBtn));}
    //////////////Payment Dialog
    public String homePaymentDialogCloseCloseBtn = "payment_dialog_close";//id
    ///////////// last closed bills dialog for cancellation
    public String homeCancellationDialogCloseBtn = "past_accounts_close";//id
    public String homeCancellationDialogFrontendTab = "frontend";//name(text)
    public String homeCancellationDialogTablesTab = "tables";//name(text)
    public String homeCancellationDialogCustomersTab = "customers";//name(text)
    ///////////// product drop down menu
    public String homeOperatorProductDropMenuPortionsOption = "portions";//name(text)
    public String homeOperatorProductDropMenuNoteOption = "note";//name(text)
    public String homeOperatorProductDropMenuDiscountOption = "discount";//name(text)
    public String homeOperatorProductDropMenuQuantityOption = "quantity";//name(text)
    public String homeOperatorProductDropMenuPriceOption = "price";//name(text)
    public String homeOperatorProductDropMenuVATOption = "VAT";//name(text)
    public String homeOperatorProductDropMenuDeleteOption = "delete";//name(text)
    public String homeOperatorProductDropMenuBroken = "broken";//name(text)
    public String homeOperatorProductDropMenuComplaint = "complaint";//name(text)
    public String homeOperatorProductDropMenuGift = "gift";//name(text)
    public String homeOperatorProductDropMenuVariant = "variant";//name(text)
    public String homeOperatorProductDropMenuDeleteVariant = "variant";//name(text)

    /////Sale Document Area element locators
    public String homeSaleDocumnentAreaBill = "payment_scontrino";//id
    public String homeSaleDocumentAreaNominalReceipt = "payment_scontrino_intestato";//id
    public String homeSaleDocumentAreaPrebill = "payment_preconto";//id
    public String homeSaleDocumentAreaDetailedProforma = "payment_estratto_conto";//id
    public String homeSaleDocumentAreaVoucher = "voucher";//id
    public String homeSaleDocumentAreaPersonal = "personal";//id
    public String homeSaleDocumentAreaBEWIRTUNGSBELEG = "payment_scontrino_finanza";//id
    public String homeSaleDocumentAreaCloseBillWithoutPrinting = "do_not_print_toggle";//id
    public String homeSaleDocumentAreaInvoice = "payment_fattura";//id
    public String homeSaleDocumentAreaRefund = "payment_nota_credito";//id

    public void selectSaleDocumentInvoiceOption (){click(By.id(homeSaleDocumentAreaInvoice));}
    public void selectSaleDocumentRefundOption(){click(By.id(homeSaleDocumentAreaRefund));}

    ////Nominal Receipt > payment customer form
    public String paymentCustomerFormTitle = "payment_doc_title";//id ,text is "select customer"
    public String paymentCustomerFormCloseBtn = "payment_annulla";//id
    public String paymentCustomerFormSelectBtn = "payment_select_cliente";//id
    public String paymentCustomerFormAddBtn = "payment_add_cliente";// id
    public String paymentCustomerFormSearchField = "cliente_ricerca_nome";//id
    public String paymentCustomerFormNameListId = "customer_name";//id
    public String paymentCustomerFormEditBtn = "payment_edit_cliente";//id
    public String paymentCustomerFormCustomerNameList = "customer_name";//id

    public void selectPaymentCustomerFormSelectButton (){click(By.id(paymentCustomerFormSelectBtn));}

    //////////////Adding new customer form
    public String nominalReceiptAddingCustomerFormSaveBtn = "payment_new_customer_save";//id
    public String nominalReceiptAddingCustomerFormTemporaryBtn = "payment_new_customer_no_save";//id
    public String nominalReceiptAddingCustomerFormCancelBtn = "payment_new_customer_cancel";//id
    public String nominalReceiptAddingCustomerFormName = "edit_customer_name";//id
    public String nominalReceiptAddingCustomerFormVatCode = "edit_partita_iva";//id
    public String nominalReceiptAddingCustomerFormTaxCode = "edit_cod_fisc";//id
    public String nominalReceiptAddingCustomerFormStreet = "edit_address_street";//id
    public String nominalReceiptAddingCustomerFormCity = "edit_address_city";//id
    public String nominalReceiptAddingCustomerFormProvince = "edit_address_prov";//id
    public String nominalReceiptAddingCustomerFormZip = "edit_address_zip";//id
    public String nominalReceiptAddingCustomerFormEmail = "edit_email";//id
    public String nominalReceiptAddingCustomerFormPhone = "edit_email";//id
    public String nominalReceiptAddingCustomerFormVatMenuId = "iva_cliente_spinner";//id
    public String nominalReceiptAddingCustomerFormVatDefaultValue = "--";//name(text)
    public String nominalReceiptAddingCustomerFormPriceListId = "listino_cliente_spinner";//id
    public String nominalReceiptAddingCustomerFormPriceListDefaultValue = "1";//name(text)

    //////Logout Form
    public String logoutForm = "alertTitle";
    public String logoutFormCancelbtn = "cancel";
    public String LogoutFormOkBtn = "OK";

    ////Error popup
    public String errorTotalAmountExceedsLimitWindowTitle = "custom_alert_title";//id
    public String errorTotalAmountExceedsLimitWindowMsg = "custom_alert_message";//id --> the text= "total amount exceeds limit"
    public String errorTotalAmountExceedsLimitWindowOkBtn = "custom_alert_positive_button";//id
    public void getErrorTitleWhenTotalAmountExceedsLimit (){
        readText(By.id(errorTotalAmountExceedsLimitWindowTitle));
    }
    public void getErrorMessageWhenTotalAmountExceedsLimit (){
        readText(By.id(errorTotalAmountExceedsLimitWindowMsg));
    }
    public void selectOkButtonInErrorMessageWhenTotalAmountExceedsLimit (){
        click(By.id(errorTotalAmountExceedsLimitWindowOkBtn));
    }
    // Cancel bill alert screen elements definition
    public String cancelBillFormTitle = "alertTitle";//id --> get text = "cancel bill"
    public String cancelBillFormYesBtn = "button1";//id --> get text = "YES"
    public String cancelBillFormNoBtn = "button2";//id --> get text = "NO"

    public void selectCancelBillYesButton (){click(By.id(cancelBillFormYesBtn));}

    public void selectCancelBillNoButton (){click(By.id(cancelBillFormNoBtn));}

    //Page methods
    public void expandOptionsDropdownMenu() {
        click(By.id(optionsButton));
    }

    public void selectDatabasesSection() {
        click(By.name(optionsDatabases));
    }

    public void selectConfigurationSection() {
        click(By.name(optionsConfiguration));
    }

    public void callSignOutForm() {
        tapOnDeviceBackKey();
    }

    public void verifyLogoutFormTitle(String expectedText) {
        Assert.assertEquals(readText(By.id(logoutForm)), expectedText);
    }

    // Methods are able to do in Home On-Screen keyboard
    public void clickOnKey0() {
        click(By.id(homeOnScreenKeyboardKey0));
    }

    public int clickOnKey1() {
        click(By.id(homeOnScreenKeyboardKey1));
        return 1;
    }

    public void clickOnKey2() {
        click(By.id(homeOnScreenKeyboardKey2));
    }

    public void clickOnKey3() {
        click(By.id(homeOnScreenKeyboardKey3));
    }

    public void clickOnKey4() {
        click(By.id(homeOnScreenKeyboardKey4));
    }

    public void clickOnKey5() {
        click(By.id(homeOnScreenKeyboardKey5));
    }

    public void clickOnKey6() {
        click(By.id(homeOnScreenKeyboardKey6));
    }

    public void clickOnKey7() {
        click(By.id(homeOnScreenKeyboardKey7));
    }

    public void clickOnKey8() {
        click(By.id(homeOnScreenKeyboardKey8));
    }

    public void clickOnKey9() {
        click(By.id(homeOnScreenKeyboardKey9));
    }

    public void clickOnKey00() {
        click(By.id(homeOnScreenKeyboardKey00));
    }

    public void clickOnKeyDot() {
        click(By.id(homeOnScreenKeyboardKeyDot));
    }

    public void clickOnKeyC() {
        click(By.id(homeOnScreenKeyboardKeyC));
    }

    public void clickOnKeyPercentMinus() {
        click(By.id(homeOnScreenKeyboardKeyPercentMinus));
    }

    public void clickOnKeyReprintLastBill(){click(By.id(homeOnScreenKeyboardKeyReprintLastBill));}

    // Methods are able to do in Department column
    public void selectADepartmentByName(String deptName) {
        click(By.name(deptName));
    }

    public void longPressADepartmentByNameToCallDropMenu(String deptName) {
        longPressOnItemByName(deptName);
    }

    public void selectDepartmentRefillReportOption() {
        click(By.name(departmentDropdownMenuRefillReportOption));
    }

    public void selectDepartmentNoRefillReportOption() {
        click(By.name(departmentDropdownMenuNoRefillReportOption));
    }

    // Methods are able to do in Operative feature access area

    // Methods are able to do in Sale Management Area
    //// Methods are able to do in Command bar

    //// Methods are able to do in Product Area
    public void cancelLogout() {
        click(By.name(logoutFormCancelbtn));
    }

    public void selectAProductByName(String prodName) {
        click(By.name(prodName));
    }

    public void longPressAProductByNameToCallDropMenu(String prodName) {
        longPressOnItemByName(prodName);
    }

    public void addProductInFavoriteListByNameOfList(String farvoriteListName) {
        click(By.name(farvoriteListName));
    }

    public void selectProductRefillReportOption() {
        click(By.name(productDropMenuRefillReport));
    }

    public void selectProductNoRefillReportOption() {
        click(By.name(productDropMenuNoRefillReport));
    }

    public void selectProductDisableOption() {
        click(By.name(productDropMenuDisableOption));
    }

    public void selectProductEditOption() {
        click(By.name(productDropMenuEditOption));
    }

    public void selectFavoriteStarIcon() {
        click(By.id(homeCommandbarFavoritelistBtn));
    }

    public void callFontSizeConfig() {
        click(By.id(homeCommandbarFontsizeBtn));
    }

    public void selectCategoriesInFontsizeMenu() {
        tapOnPoint(fontsizeMenuCategoriesOption[0], fontsizeMenuCategoriesOption[1]);
    }

    public void selectProductsInFontsizeMenu() {
        tapOnPoint(fontsizeMenuProductsOption[0], fontsizeMenuProductsOption[1]);
    }

    public void selectBillInFontsizeMenu() {
        tapOnPoint(fontsizeMenuBillOption[0], fontsizeMenuBillOption[1]);
    }

    public void increaseFontsize(int times) {
        tapOnPointInTimes(fontsizeMenuPlusBtn[0], fontsizeMenuPlusBtn[1], times);
    }

    public void expandOnScreenKeyBoard() {
        click(By.id(homeCommandbarOnOffScreenKeyboardBtn));
    }

    public void collapseOnScreenKeyBoard() {
        click(By.id(homeCommandbarOnOffScreenKeyboardBtn));
    }

    /////Methods for Sale Document Area element locators
    public void selectCloseBillWithoutPrinting(){
        click(By.id(homeSaleDocumentAreaCloseBillWithoutPrinting));
    }

    public void selectOperatorDisplayTotalButton(){
        click(By.id(homeOperatorDisplayAreaTotalBtn));
    }

    //Define elements and methods for DEMO warning pop up screen
    public String demoWarningScreenTitleId = "alertTitle";
    public String demoWarningScreenMessageId = "message";// get text (the system is in DEMO mode, fiscalization is pending)
    public String getDemoWarningMessage(){ return readText(By.id(demoWarningScreenMessageId));}
    public String demoWarningScreenOkId = "button1";
    public void selectOKButton(){click(By.id(demoWarningScreenOkId));}
    public void selectOkInDemoWarningScreen(){click(By.id(demoWarningScreenOkId));}

    //Define elements and methods for closure confirmation screen
    public String closureConfirmationOkButtonId = "custom_alert_positive_button";
    public String closureConfirmationCancelButtonId = "custom_alert_negative_button";
    public void selectOkInClosureConfirmation(){click(By.id(closureConfirmationOkButtonId));}
    public void selectCancelInClosureConfirmation(){click(By.id(closureConfirmationCancelButtonId));}

    //Define elements and methods for report confirmation screen
    public String reportConfirmationYesButtonId = "button1";
    public String reportConfirmationNoButtonId = "button2";
    public void selectCANCELButton(){click(By.id(reportConfirmationNoButtonId));}
    public void selectNoInReportConfirmation(){click(By.id(reportConfirmationNoButtonId));}

    // define element and method option "print bill under 25 EUR" for France Olivetti
    public String franceNotPrintBillUnder25EurCheckboxId = "not_print_bill_under_25_euro_toggle";
    public void checkNotPrintBillUnder25(){
        boolean isCheck = isChecked(By.id(franceNotPrintBillUnder25EurCheckboxId));
        if (isCheck == false)
            click(By.id(franceNotPrintBillUnder25EurCheckboxId));
    }
    public void uncheckNotPrintBillUnder25(){
        boolean isCheck = isChecked(By.id(franceNotPrintBillUnder25EurCheckboxId));
        if (isCheck == true)
            click(By.id(franceNotPrintBillUnder25EurCheckboxId));
    }
}
