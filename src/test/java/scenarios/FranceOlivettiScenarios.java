package scenarios;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.expression.spel.ast.Operator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utils.ExtentReports.ExtentTestManager;
import utils.TestDataManagement.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.By.id;
import java.lang.ProcessBuilder;


public class FranceOlivettiScenarios extends AndroidSetup {

    // test data for create a test product
    FiscalInformationData fiscalInfo01 = new FiscalInformationData();
    FiscalInformationData fiscalInfo02 = new FiscalInformationData();
    // end of define test data

    @Parameters(value = "apkFilePath")
    @BeforeClass
    public void setUp(String apkFilePath) throws Exception {
        prepareAndroidForAppium(apkFilePath);
    }


    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();

    }

    // LAUNCH APP IN DEMO MODE

    @Test(priority = 1)
    public void loginByTechnicianAccount() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("Login by Technician account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByTechnician();
    }

    @Test(priority = 2)
    public void verifyAppStartInDemoMode() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("App start in demo mode and pop up a warning screen");
        HomePage homePage = new HomePage(driver);
        homePage.selectOkInDemoWarningScreen();
    }

    // USING APP IN DEMO MODE

    @Test(priority = 3)
    public void importTestExcelDataFile() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("Go to Database | Pricelist section");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectDatabasesSection();
        DatabaseManagementPage databaseManagementPage = new DatabaseManagementPage(driver);
        databaseManagementPage.selectDatabasesManagementTab();
        databaseManagementPage.selectImportDataButton();
        databaseManagementPage.scrollToText("db_20180814_054722_40603200.xls");// the data excel file name
        databaseManagementPage.click(By.name("db_20180814_054722_40603200.xls"));// the data excel file name
        Thread.sleep(30000);
        databaseManagementPage.tapOnDeviceBackKey();
        Thread.sleep(3000);
        // Make a bill in Front end right after data is successfully imported
        homePage.selectADepartmentByName(DepartmentData.mainCourses);
        homePage.selectAProductByName(DepartmentData.MAIN_COURSES_CheeseCrepes);
        homePage.selectOperatorDisplayTotalButton();
        // Make a bill inside a table right after data is successfully imported
        homePage.selectTablesTab();
        TablePlaningPage tablePlaningPage = new TablePlaningPage(driver);
        TablePage tablePage = new TablePage(driver);
        tablePlaningPage.selectATableByName("2");
        tablePage.selectADepartmentByName(DepartmentData.beer);
        tablePage.selectAProductByName(DepartmentData.BEER_Carlsberg);
        tablePage.selectAProductByName(DepartmentData.BEER_Corona);
        tablePage.swipeRightToLeftInElementDimensionFindById(1000,tablePage.orderScreenLeftSideProductGridId);
        tablePage.selectBillOption();
        tablePage.selectYesBillConfirmation();
        homePage.selectOperatorDisplayTotalButton();
        Thread.sleep(3000);

    }

    @Test (priority = 4)
    public void verifyFunctionNotPrintBillUnder25IsCheckedInDemoMode()throws InterruptedException{

        ExtentTestManager.getTest().setDescription("the 1st re-print of bill under 25 from document when App does not allow print bill");
        HomePage homePage = new HomePage(driver);
        homePage.swipeRightToLeft(2000);
        Thread.sleep(4000);
        homePage.checkNotPrintBillUnder25();
        homePage.swipeLeftToRight(1000);
        Thread.sleep(2000);
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_Becks);
        homePage.selectOperatorDisplayTotalButton();
        homePage.expandOptionsDropdownMenu();
        homePage.selectDocumentsOption();
        DocumentsReceiptsPage documentsReceiptsPage = new DocumentsReceiptsPage(driver);
        documentsReceiptsPage.selectReceiptsOption();
        documentsReceiptsPage.selectCalculateButton();
        documentsReceiptsPage.click(By.name("3.00"));
        documentsReceiptsPage.selectReprintIcon();
        Thread.sleep(8000);
        documentsReceiptsPage.tapOnDeviceBackKey();
        Thread.sleep(2000);
        documentsReceiptsPage.tapOnDeviceBackKey();
        Thread.sleep(2000);
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_DoubleMaltbeer);
        homePage.expandOnScreenKeyBoard();
        homePage.clickOnKeyReprintLastBill();

        // make 2 invoice receipts, the 1st invoice
        homePage.swipeRightToLeft(1000);
        homePage.selectSaleDocumentInvoiceOption();
        homePage.selectACustomerByName(CustomerData.TEST_DEFAULT_CUSTOMER_NAME);
        homePage.selectPaymentCustomerFormSelectButton();
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_DraughtBeer);
        homePage.selectOperatorDisplayTotalButton();
        Thread.sleep(5000);
        // the 2nd invoice
        homePage.swipeRightToLeft(1000);
        homePage.selectSaleDocumentInvoiceOption();
        homePage.selectACustomerByName(CustomerData.TEST_DEFAULT_CUSTOMER_NAME);
        homePage.selectPaymentCustomerFormSelectButton();
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_Paleale);
        homePage.selectOperatorDisplayTotalButton();
    }

    @Test (priority = 5)
    public void FunctionNotPrintBillUnder25IsUncheckedInDemoMode()throws  InterruptedException{
        ExtentTestManager.getTest().setDescription("app allow print bill under 25 if it's checked");
        HomePage homePage = new HomePage(driver);
        homePage.collapseOnScreenKeyBoard();
        homePage.swipeRightToLeft(3000);
        homePage.uncheckNotPrintBillUnder25();
        homePage.swipeLeftToRight(2000);
        homePage.selectADepartmentByName(DepartmentData.dessert);
        homePage.selectAProductByName(DepartmentData.DESSERT_Cenci);
        homePage.selectAProductByName(DepartmentData.DESSERT_Cantuccini);
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_Becks);
        homePage.selectAProductByName(DepartmentData.BEER_Corona);
        homePage.selectOperatorDisplayTotalButton();

        // the 1st refund receipt
        homePage.swipeRightToLeft(1000);
        homePage.selectSaleDocumentRefundOption();
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_DraughtBeer);
        homePage.selectOperatorDisplayTotalButton();
        Thread.sleep(5000);

        // the 2nd refund receipt
        homePage.swipeRightToLeft(1000);
        homePage.selectSaleDocumentRefundOption();
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_Franzizkaner);
        homePage.selectOperatorDisplayTotalButton();
    }

    // CREATE THE TEST OPERATOR AS A TRAINEE ACCOUNT TO USING APP IN TRAINING MODE
    OperatorData testOperator1 = new OperatorData();
    @Test (priority = 6)
    public void createAnOperatorAsATraineeAccount () throws InterruptedException{
        ExtentTestManager.getTest().setDescription("Create an operator and enable Training mode");
        // Open Configurations > Operators tab
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        // create a test operator
        ConfigurationOperatorsPage configurationOperatorsPage = new ConfigurationOperatorsPage(driver);
        configurationOperatorsPage.selectOperatorsTab();
        testOperator1.setName("trainee 1");
        configurationOperatorsPage.selectAddNewOperatorButton();
        configurationOperatorsPage.inputNewOperatorName(testOperator1.getName());
        configurationOperatorsPage.selectOkButton();
        // select the new operator
        configurationOperatorsPage.selectAnOperatorByName(testOperator1.getName());
        // get the password of new created operator
        testOperator1.setCode(configurationOperatorsPage.getOperatorCode());
        char[] codeCharArray = configurationOperatorsPage.getOperatorCode().toCharArray();
        // Enable Training mode
        configurationOperatorsPage.switchOnEnableTrainingModeOption();
        // Switch On Is allowed to close a bill option
        configurationOperatorsPage.switchOnIsAllowedToCloseABillOption();
        // select save button
        configurationOperatorsPage.selectSaveOptionsButton();
        // back to front end screen
        configurationOperatorsPage.tapOnDeviceBackKey();
        Thread.sleep(3000);
        //logout tech account
        homePage.expandOptionsDropdownMenu();
        homePage.selectLockOption();
        // login by Trainee 1 account
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByGetCodeOfOperator(codeCharArray);
        homePage.selectOKButton();
        // pay and close some bills at the front-end by Trainee account
        homePage.selectADepartmentByName(DepartmentData.dessert);
        homePage.selectAProductByName(DepartmentData.DESSERT_Cenci);
        homePage.selectOperatorDisplayTotalButton();
        Thread.sleep(10000);
        // logout Trainee 1 account
        homePage.expandOptionsDropdownMenu();
        homePage.selectLockOption();
        homePage.selectOKButton(); // bug no pop up when using Lock option but it works when select device Back key
        // login Technician account
        loginPage.loginByTechnician();
        homePage.selectOkInDemoWarningScreen();
        Thread.sleep(3000);
    }

    @Test (priority = 7)
    public void checkTheIncreasingOfReceiptNumberInDemoMode()throws InterruptedException{
        ExtentTestManager.getTest().setDescription("ensure that the receipt number always increase");
        HomePage homePage = new HomePage(driver);
        TillFunctionsPage tillFunctionsPage = new TillFunctionsPage(driver);
        // do xreport (daily report)
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectDailyReportOption();
        tillFunctionsPage.selectGlobalOption();
        // daily closure
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectDailyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // weekly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectWeeklyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // monthly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectMonthlyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // yearly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectYearlyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();

        //make a new bill and the receipt number must not be reset it should be increased
        homePage.selectADepartmentByName(DepartmentData.fish);
        homePage.selectAProductByName(DepartmentData.FISH_Lobster);
        homePage.selectAProductByName(DepartmentData.FISH_SeaBass);
        homePage.selectOperatorDisplayTotalButton();
    }

    @Test (priority = 8)
    public void checkTheIncreasingOfReceiptNumberByAdminAccountInDemoMode()throws InterruptedException{
        ExtentTestManager.getTest().setDescription("ensure that the receipt number always increase when user login by other account like administrator");
        HomePage homePage = new HomePage(driver);
        TillFunctionsPage tillFunctionsPage = new TillFunctionsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        //logout tech account
        homePage.expandOptionsDropdownMenu();
        homePage.selectLockOption();
        // Login by Admin account
        loginPage.pressKeyNumber9();
        loginPage.pressKeyNumber9();
        loginPage.pressKeyNumber9();
        loginPage.pressKeyNumber9();
        loginPage.pressKeyOK();
        homePage.selectOkInDemoWarningScreen();
        //make a new bill under 25 eur
        homePage.selectADepartmentByName(DepartmentData.drink);
        homePage.selectAProductByName(DepartmentData.DRINK_Cappuccino);
        homePage.selectOperatorDisplayTotalButton();
        //make a new bill over 25
        homePage.selectADepartmentByName(DepartmentData.fish);
        homePage.selectAProductByName(DepartmentData.FISH_GiltheadSeaBream);
        homePage.selectAProductByName(DepartmentData.FISH_SeaBass);
        homePage.selectOperatorDisplayTotalButton();
        homePage.expandOptionsDropdownMenu();
        homePage.selectDocumentsOption();
        DocumentsReceiptsPage documentsReceiptsPage = new DocumentsReceiptsPage(driver);
        documentsReceiptsPage.selectReceiptsOption();
        documentsReceiptsPage.selectCalculateButton();
        documentsReceiptsPage.click(By.name("27.00"));
        documentsReceiptsPage.selectReprintIcon();
        Thread.sleep(8000);
        documentsReceiptsPage.tapOnDeviceBackKey();
        Thread.sleep(2000);
        documentsReceiptsPage.tapOnDeviceBackKey();
        Thread.sleep(2000);
        // do xreport (daily report)
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectDailyReportOption();
        tillFunctionsPage.selectGlobalOption();
        // daily closure
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectDailyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // weekly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectWeeklyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // monthly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectMonthlyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // yearly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectYearlyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        //make a new bill
        homePage.selectADepartmentByName(DepartmentData.fish);
        homePage.selectAProductByName(DepartmentData.FISH_Lobster);
        homePage.selectAProductByName(DepartmentData.FISH_SeaBass);
        homePage.selectOperatorDisplayTotalButton();
        homePage.expandOptionsDropdownMenu();
        homePage.selectLockOption();
    }

    // FILL DATA IN FISCAL INFORMATION TO MAKE THE POS MACHINE IS FISCALIZED

    @Test(priority = 9)
    public void reloginByTechnicianAccount() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("Login by Technician account");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.loginByTechnician();
        homePage.selectOkInDemoWarningScreen();
    }

    @Test(priority = 10)
    public void fiscalizePOSWithoutSubmitFiscalInfo() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("register fiscal information to fiscalize the POS machine");
        HomePage homePage = new HomePage(driver);
        ConfigurationCashRegisterPage configurationCashRegisterPage = new ConfigurationCashRegisterPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        configurationCashRegisterPage.selectCashRegisterTab();
        configurationCashRegisterPage.selectFiscalInformationSection();
        configurationCashRegisterPage.selectFiscalInfoSaveButton();
        Thread.sleep(3000);
    }

    @Test(priority = 11)
    public void fiscalizePOSInCaseFiscalInfoHasDataInOnlyOptionalFields() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("register fiscal information to fiscalize the POS machine");
        HomePage homePage = new HomePage(driver);
        ConfigurationCashRegisterPage configurationCashRegisterPage = new ConfigurationCashRegisterPage(driver);
        fiscalInfo01.setVendorName(GeneralData.randomAlphaNumeric(20));
        fiscalInfo01.setStreetNumber(GeneralData.randomAlphaNumeric(15));
        fiscalInfo01.setStreetName(GeneralData.randomAlphaNumeric(30));
        fiscalInfo01.setCityName(GeneralData.randomAlphaNumeric(10));
        configurationCashRegisterPage.inputDataFiscalInfoVendorName(fiscalInfo01.getVendorName());
        configurationCashRegisterPage.inputDataFiscalInfoStreetNumber(fiscalInfo01.getStreetNumber());
        configurationCashRegisterPage.inputDataFiscalInfoStreetName(fiscalInfo01.getStreetName());
        configurationCashRegisterPage.inputDataFiscalInfoCityName(fiscalInfo01.getCityName());
        configurationCashRegisterPage.selectFiscalInfoSaveButton();
        configurationCashRegisterPage.clearDataFiscalInfoVendorName();
        configurationCashRegisterPage.clearDataFiscalInfoStreetNumber();
        configurationCashRegisterPage.clearDataFiscalInfoStreetName();
        configurationCashRegisterPage.clearDataFiscalInfoCityName();
        Thread.sleep(3000);
        configurationCashRegisterPage.tapOnDeviceBackKey();
    }
    /*
    @Test(priority = 11)
    public void fiscalizePOSInCaseFiscalInfoHasDataInOnlyMandatoryFields() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("register fiscal information to fiscalize the POS machine");
        HomePage homePage = new HomePage(driver);
        fiscalInfo01.setSiretNumber(GeneralData.randomAlphaNumeric(14));
        fiscalInfo01.setNafNumber(GeneralData.randomAlphaNumeric(5));
        fiscalInfo01.setTvaNumber(GeneralData.randomAlphaNumeric(13));
        ConfigurationCashRegisterPage configurationCashRegisterPage = new ConfigurationCashRegisterPage(driver);
        configurationCashRegisterPage.clearDataFiscalInfoVendorName();
        configurationCashRegisterPage.clearDataFiscalInfoStreetNumber();
        configurationCashRegisterPage.clearDataFiscalInfoStreetName();
        configurationCashRegisterPage.clearDataFiscalInfoCityName();
        configurationCashRegisterPage.inputDataFiscalInfoSiretNumber(fiscalInfo01.getSiretNumber());
        configurationCashRegisterPage.inputDataFiscalInfoNafNumber(fiscalInfo01.getNafNumber());
        configurationCashRegisterPage.inputDataFiscalInfoTvaNumber(fiscalInfo01.getTvaNumber());
        configurationCashRegisterPage.selectFiscalInfoSaveButton();
        configurationCashRegisterPage.selectFiscalInfoWarningOkButton();
        configurationCashRegisterPage.selectFiscalizationMachineConfirmationOk();
        Thread.sleep(1000);
    }
    */
    @Test(priority = 12)
    public void fiscalizePOSMachineByFullFiscalInfo() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("register fiscal information to fiscalize the POS machine");
        HomePage homePage = new HomePage(driver);
        ConfigurationCashRegisterPage configurationCashRegisterPage = new ConfigurationCashRegisterPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        configurationCashRegisterPage.selectCashRegisterTab();
        configurationCashRegisterPage.selectFiscalInformationSection();
        fiscalInfo01.setVendorName(GeneralData.randomAlphaNumeric(20));
        fiscalInfo01.setStreetNumber(GeneralData.randomAlphaNumeric(15));
        fiscalInfo01.setStreetName(GeneralData.randomAlphaNumeric(30));
        fiscalInfo01.setCityName(GeneralData.randomAlphaNumeric(10));
        fiscalInfo01.setSiretNumber(GeneralData.randomAlphaNumeric(14));
        fiscalInfo01.setNafNumber(GeneralData.randomAlphaNumeric(5));
        fiscalInfo01.setTvaNumber(GeneralData.randomAlphaNumeric(13));
        configurationCashRegisterPage.inputDataFiscalInfoVendorName(fiscalInfo01.getVendorName());
        configurationCashRegisterPage.inputDataFiscalInfoStreetNumber(fiscalInfo01.getStreetNumber());
        configurationCashRegisterPage.inputDataFiscalInfoStreetName(fiscalInfo01.getStreetName());
        configurationCashRegisterPage.inputDataFiscalInfoCityName(fiscalInfo01.getCityName());
        configurationCashRegisterPage.inputDataFiscalInfoSiretNumber(fiscalInfo01.getSiretNumber());
        configurationCashRegisterPage.inputDataFiscalInfoNafNumber(fiscalInfo01.getNafNumber());
        configurationCashRegisterPage.inputDataFiscalInfoTvaNumber(fiscalInfo01.getTvaNumber());
        configurationCashRegisterPage.selectFiscalInfoSaveButton();
        configurationCashRegisterPage.selectFiscalInfoWarningOkButton();
        configurationCashRegisterPage.selectFiscalizationMachineConfirmationOk();
        Thread.sleep(1000);
    }

    @Test(priority = 13)
    public void loginByTechnicianAfterFiscalizationDone() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("login App again after the machine is fiscalized");
        Thread.sleep(5000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByTechnician();
        HomePage homePage = new HomePage(driver);
        ConfigurationCashRegisterPage configurationCashRegisterPage = new ConfigurationCashRegisterPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        configurationCashRegisterPage.selectCashRegisterTab();
        configurationCashRegisterPage.selectFiscalInformationSection();
        Thread.sleep(10000);
        configurationCashRegisterPage.tapOnDeviceBackKey();
    }

    // USING APP IN FISCAL MODE

    @Test (priority = 14)
    public void verifyTheFirstPrintOfBillUnder25InStandardMode()throws InterruptedException{
        ExtentTestManager.getTest().setDescription("the 1st re-print of bill under 25 from document when App does not allow print bill");
        HomePage homePage = new HomePage(driver);
        homePage.swipeRightToLeft(3000);
        homePage.checkNotPrintBillUnder25();
        homePage.swipeLeftToRight(1000);
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_Becks);
        homePage.selectOperatorDisplayTotalButton();
        homePage.expandOptionsDropdownMenu();
        homePage.selectDocumentsOption();
        DocumentsReceiptsPage documentsReceiptsPage = new DocumentsReceiptsPage(driver);
        documentsReceiptsPage.selectReceiptsOption();
        documentsReceiptsPage.selectCalculateButton();
        documentsReceiptsPage.click(By.name("technician"));
        documentsReceiptsPage.selectReprintIcon();
        Thread.sleep(8000);
        documentsReceiptsPage.selectBackButton();
        //documentsReceiptsPage.tapOnDeviceBackKey();
        Thread.sleep(2000);
        documentsReceiptsPage.selectBackButton();
        //documentsReceiptsPage.tapOnDeviceBackKey();
        Thread.sleep(2000);

        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_DoubleMaltbeer);
        homePage.expandOnScreenKeyBoard();
        homePage.clickOnKeyReprintLastBill();

        // make 2 invoice receipts, the 1st invoice
        homePage.swipeRightToLeft(1000);
        homePage.selectSaleDocumentInvoiceOption();
        homePage.selectACustomerByName(CustomerData.TEST_DEFAULT_CUSTOMER_NAME);
        homePage.selectPaymentCustomerFormSelectButton();
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_DraughtBeer);
        homePage.selectOperatorDisplayTotalButton();
        Thread.sleep(5000);

        // the 2nd invoice
        homePage.swipeRightToLeft(1000);
        homePage.selectSaleDocumentInvoiceOption();
        homePage.selectACustomerByName(CustomerData.TEST_DEFAULT_CUSTOMER_NAME);
        homePage.selectPaymentCustomerFormSelectButton();
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_Paleale);
        homePage.selectOperatorDisplayTotalButton();
    }

    @Test (priority = 15)
    public void uncheckOptionNotPrintBillUnder25InStandardMode()throws  InterruptedException{
        ExtentTestManager.getTest().setDescription("app allow print bill under 25 if it's checked ");
        HomePage homePage = new HomePage(driver);
        homePage.swipeRightToLeft(3000);
        homePage.uncheckNotPrintBillUnder25();
        homePage.swipeLeftToRight(1000);
        homePage.selectADepartmentByName(DepartmentData.dessert);
        homePage.selectAProductByName(DepartmentData.DESSERT_Cenci);
        homePage.selectAProductByName(DepartmentData.DESSERT_Cantuccini);
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_Becks);
        homePage.selectAProductByName(DepartmentData.BEER_Corona);
        homePage.selectOperatorDisplayTotalButton();
        // the 1st refund receipt
        homePage.swipeRightToLeft(1000);
        homePage.selectSaleDocumentRefundOption();
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_DraughtBeer);
        homePage.selectOperatorDisplayTotalButton();
        Thread.sleep(5000);
        // the 2nd refund receipt
        homePage.swipeRightToLeft(1000);
        homePage.selectSaleDocumentRefundOption();
        homePage.selectADepartmentByName(DepartmentData.beer);
        homePage.selectAProductByName(DepartmentData.BEER_Franzizkaner);
        homePage.selectOperatorDisplayTotalButton();
        Thread.sleep(2000);
    }

    @Test (priority = 16)
    public void checkTheIncreasingOfReceiptNumberInStandardMode()throws InterruptedException{
        ExtentTestManager.getTest().setDescription("ensure that the receipt number always increase");
        HomePage homePage = new HomePage(driver);
        TillFunctionsPage tillFunctionsPage = new TillFunctionsPage(driver);
        // do xreport (daily report)
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectDailyReportOption();
        tillFunctionsPage.selectGlobalOption();
        // daily closure
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectDailyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // weekly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectWeeklyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // monthly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectMonthlyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // yearly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectYearlyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        //make a new bill
        homePage.selectADepartmentByName(DepartmentData.fish);
        homePage.selectAProductByName(DepartmentData.FISH_Lobster);
        homePage.selectAProductByName(DepartmentData.FISH_SeaBass);
        homePage.selectOperatorDisplayTotalButton();
        homePage.expandOptionsDropdownMenu();
        homePage.selectDocumentsOption();
        DocumentsReceiptsPage documentsReceiptsPage = new DocumentsReceiptsPage(driver);
        documentsReceiptsPage.selectReceiptsOption();
        documentsReceiptsPage.selectCalculateButton();
        documentsReceiptsPage.click(By.name("technician"));
        documentsReceiptsPage.selectReprintIcon();
        Thread.sleep(8000);
        documentsReceiptsPage.tapOnDeviceBackKey();
        Thread.sleep(3000);
        documentsReceiptsPage.tapOnDeviceBackKey();
        Thread.sleep(3000);
    }

    @Test (priority = 17)
    public void checkTheIncreasingOfReceiptNumberByAdminAccountInStandardMode()throws InterruptedException{
        ExtentTestManager.getTest().setDescription("ensure that the receipt number always increase when user login by other account like administrator");
        HomePage homePage = new HomePage(driver);
        TillFunctionsPage tillFunctionsPage = new TillFunctionsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        //logout technician account
        homePage.expandOptionsDropdownMenu();
        homePage.selectLockOption();
        // Login by Admin account
        loginPage.pressKeyNumber9();
        loginPage.pressKeyNumber9();
        loginPage.pressKeyNumber9();
        loginPage.pressKeyNumber9();
        loginPage.pressKeyOK();
        //make a new bill under 25 eur
        homePage.selectADepartmentByName(DepartmentData.drink);
        homePage.selectAProductByName(DepartmentData.DRINK_Cappuccino);
        homePage.selectOperatorDisplayTotalButton();
        //make a new bill over 25
        homePage.selectADepartmentByName(DepartmentData.fish);
        homePage.selectAProductByName(DepartmentData.FISH_GiltheadSeaBream);
        homePage.selectAProductByName(DepartmentData.FISH_SeaBass);
        homePage.selectOperatorDisplayTotalButton();
        homePage.expandOptionsDropdownMenu();
        homePage.selectDocumentsOption();
        DocumentsReceiptsPage documentsReceiptsPage = new DocumentsReceiptsPage(driver);
        documentsReceiptsPage.selectReceiptsOption();
        documentsReceiptsPage.selectCalculateButton();
        documentsReceiptsPage.click(By.name("technician"));
        documentsReceiptsPage.selectReprintIcon();
        Thread.sleep(8000);
        documentsReceiptsPage.tapOnDeviceBackKey();
        Thread.sleep(2000);
        documentsReceiptsPage.tapOnDeviceBackKey();
        Thread.sleep(2000);
        // do xreport (daily report)
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectDailyReportOption();
        tillFunctionsPage.selectGlobalOption();
        // daily closure
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectDailyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // weekly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectWeeklyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // monthly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectMonthlyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // yearly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectYearlyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        //make a new bill
        homePage.selectADepartmentByName(DepartmentData.fish);
        homePage.selectAProductByName(DepartmentData.FISH_Lobster);
        homePage.selectAProductByName(DepartmentData.FISH_SeaBass);
        homePage.selectOperatorDisplayTotalButton();

        //Verify the Admin account can see the fiscal info
        ConfigurationCashRegisterPage configurationCashRegisterPage = new ConfigurationCashRegisterPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        configurationCashRegisterPage.selectCashRegisterTab();
        configurationCashRegisterPage.selectFiscalInformationSection();

        //Back to front end and logout of POS
        configurationCashRegisterPage.tapOnDeviceBackKey();
        homePage.expandOptionsDropdownMenu();
        homePage.selectLockOption();
    }

    // RESET THE POS MACHINE TO REFURBISH AND RE-SELL IT TO OTHER OWNER

    @Test(priority = 18)
    public void loginByTechnicianAccountToRefurbishTheMachine() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("login App again after the machine is fiscalized");
        Thread.sleep(3000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByTechnician();
    }

    @Test (priority = 19)
    public void refurbishThePOSMachine()throws InterruptedException {
        ExtentTestManager.getTest().setDescription("refurbish the POS machine");
        HomePage homePage = new HomePage(driver);
        TillFunctionsPage tillFunctionsPage = new TillFunctionsPage(driver);
        DatabaseManagementPage databaseManagementPage = new DatabaseManagementPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        // daily closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectDailyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // weekly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectWeeklyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // monthly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectMonthlyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // yearly closure
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectClosureOption();
        tillFunctionsPage.selectYearlyClosure();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // refurbish the POS machine
        homePage.expandOptionsDropdownMenu();
        homePage.selectDatabasesSection();
        databaseManagementPage.selectDatabasesManagementTab();
        databaseManagementPage.selectRefurbishButton();
        databaseManagementPage.selectRefurbishConfirmationOkButton();
        Thread.sleep(30000);
        loginPage.selectManualRestartConfirmationOkButton();
        //Relaunch app again
        DeviceCommand deviceCommand = new DeviceCommand(driver);
        deviceCommand.relaunchApp();
    }

    // LOGIN APP BY TECHNICIAN ACCOUNT AFTER THE POS IS REFURBISHED --> APP SHOULD BE LAUNCHED IN DEMO MODE
    @Test(priority = 20)
    public void  loginByTechnicianAccountAfterRefurbishThePOSMachine() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("Login by Technician account");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.loginByTechnician();
        homePage.selectOkInDemoWarningScreen();
        Thread.sleep(3000);
        ConfigurationCashRegisterPage configurationCashRegisterPage = new ConfigurationCashRegisterPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        configurationCashRegisterPage.selectCashRegisterTab();
        configurationCashRegisterPage.selectFiscalInformationSection();
        configurationCashRegisterPage.tapOnDeviceBackKey();
    }

    // USING APP AFTER IT IS REFURBISHED (DEMO MODE IS DEFAULT)

    @Test(priority = 21)
    public void usingAppInDemoModeAfterRefurbished() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("verify using app after it's refurbished");
        HomePage homePage = new HomePage(driver);
        // import excel test data again
        homePage.expandOptionsDropdownMenu();
        homePage.selectDatabasesSection();
        DatabaseManagementPage databaseManagementPage = new DatabaseManagementPage(driver);
        databaseManagementPage.selectDatabasesManagementTab();
        databaseManagementPage.selectImportDataButton();
        databaseManagementPage.scrollToText("db_20180814_054722_40603200.xls");// the data excel file name
        databaseManagementPage.click(By.name("db_20180814_054722_40603200.xls"));// the data excel file name
        Thread.sleep(20000);
        databaseManagementPage.tapOnDeviceBackKey();
        Thread.sleep(3000);
        // Make a bill in Front end
        homePage.selectADepartmentByName(DepartmentData.mainCourses);
        homePage.selectAProductByName(DepartmentData.MAIN_COURSES_CheeseCrepes);
        homePage.selectADepartmentByName(DepartmentData.drink);
        homePage.selectAProductByName(DepartmentData.DRINK_Fanta);
        homePage.selectAProductByName(DepartmentData.DRINK_Cappuccino);
        homePage.selectOperatorDisplayTotalButton();
        // Make a bill inside a table
        homePage.selectTablesTab();
        TablePlaningPage tablePlaningPage = new TablePlaningPage(driver);
        TablePage tablePage = new TablePage(driver);
        tablePlaningPage.selectATableByName("2");
        tablePage.selectADepartmentByName(DepartmentData.beer);
        tablePage.selectAProductByName(DepartmentData.BEER_Carlsberg);
        tablePage.selectAProductByName(DepartmentData.BEER_Corona);
        tablePage.swipeRightToLeftInElementDimensionFindById(1000,tablePage.orderScreenLeftSideProductGridId);
        tablePage.selectBillOption();
        tablePage.selectYesBillConfirmation();
        homePage.selectOperatorDisplayTotalButton();
        Thread.sleep(10000);
    }
    //CHANGE APP FROM DEMO TO FISCAL MODE
    @Test(priority = 22)
    public void fiscalizeApp2ndTime()throws InterruptedException{
        ExtentTestManager.getTest().setDescription("register fiscal information to fiscalize the POS machine");
        HomePage homePage = new HomePage(driver);
        ConfigurationCashRegisterPage configurationCashRegisterPage = new ConfigurationCashRegisterPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        configurationCashRegisterPage.selectCashRegisterTab();
        configurationCashRegisterPage.selectFiscalInformationSection();
        fiscalInfo02.setVendorName(GeneralData.randomAlphaNumericSymbol(30));
        fiscalInfo02.setStreetNumber(GeneralData.randomAlphaNumericSymbol(20));
        fiscalInfo02.setStreetName(GeneralData.randomAlphaNumericSymbol(23));
        fiscalInfo02.setCityName(GeneralData.randomAlphaNumericSymbol(10));
        fiscalInfo02.setSiretNumber(GeneralData.randomAlphaNumeric(14));
        fiscalInfo02.setNafNumber(GeneralData.randomAlphaNumeric(5));
        fiscalInfo02.setTvaNumber(GeneralData.randomAlphaNumeric(13));
        configurationCashRegisterPage.inputDataFiscalInfoVendorName(fiscalInfo02.getVendorName());
        configurationCashRegisterPage.inputDataFiscalInfoStreetNumber(fiscalInfo02.getStreetNumber());
        configurationCashRegisterPage.inputDataFiscalInfoStreetName(fiscalInfo02.getStreetName());
        configurationCashRegisterPage.inputDataFiscalInfoCityName(fiscalInfo02.getCityName());
        configurationCashRegisterPage.inputDataFiscalInfoSiretNumber(fiscalInfo02.getSiretNumber());
        configurationCashRegisterPage.inputDataFiscalInfoNafNumber(fiscalInfo02.getNafNumber());
        configurationCashRegisterPage.inputDataFiscalInfoTvaNumber(fiscalInfo02.getTvaNumber());
        configurationCashRegisterPage.selectFiscalInfoSaveButton();
        configurationCashRegisterPage.selectFiscalInfoWarningOkButton();
        configurationCashRegisterPage.selectFiscalizationMachineConfirmationOk();
        Thread.sleep(1000);
    }
    // LOGIN APP AGAIN
    // USING APP IN FISCAL MODE
    // CREATE A TEST OPERATOR AS A TRAINEE ACCOUNT TO ACCESS THE TRAINING MODE
    // REFURBISH APP AGAIN
}
