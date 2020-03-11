package scenarios;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utils.ExtentReports.ExtentTestManager;
import utils.TestDataManagement.DepartmentData;
import utils.TestDataManagement.GeneralData;
import utils.TestDataManagement.OperatorData;
import utils.TestDataManagement.ProductData;

public class EpicTEST78 extends AndroidSetup {
    @Parameters(value = "apkFilePath")
    @BeforeClass
    public void setUp(String apkFilePath) throws Exception {
        prepareAndroidForAppium(apkFilePath);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test(priority = 1)
    public void loginByTechnicianAccount() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("Login by Technician account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByTechnician();
    }

    @Test (priority = 2)
    public void setupPrinter() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("setup printer for bills");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationPrintersPage configurationPrintersPage = new ConfigurationPrintersPage(driver);
        configurationPrintersPage.goToPrinterSection();
        configurationPrintersPage.selectPrinter(GeneralData.DEFAULT_PRINTER_01);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);// The printer IP must be changed when run test in other network
        configurationPrintersPage.selectSaveButton();
        configurationPrintersPage.selectPrinter(GeneralData.DEFAULT_PRINTER_02);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);
        configurationPrintersPage.selectSaveButton();
        configurationPrintersPage.selectPrinter(GeneralData.DEFAULT_PRINTER_03);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);
        configurationPrintersPage.selectSaveButton();
        configurationPrintersPage.selectPrinter(GeneralData.DEFAULT_PRINTER_BILLS);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);
        configurationPrintersPage.selectSaveButton();
        configurationPrintersPage.selectPrinter(GeneralData.DEFAULT_PRINTER_SUMMARY);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);
        configurationPrintersPage.selectSaveButton();
        configurationPrintersPage.selectPrinter(GeneralData.DEFAULT_PRINTER_DOCS);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);
        configurationPrintersPage.selectSaveButton();
        configurationPrintersPage.tapOnDeviceBackKey();
    }

    // test data for creating sample test products
    ProductData testProd01 = new ProductData();

    @Test (priority = 3)
    public void createProduct01HasPrices() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("create a new product");
        DatabaseProductPage databaseProductPage = new DatabaseProductPage(driver);

        //precondition
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectDatabasesSection();
        DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);
        databaseDepartmentPage.selectDepartment(GeneralData.DEFAULT_DEPT_01);
        databaseProductPage.goToProductCreatingForm();

        testProd01.setName("testProd01");
        testProd01.setSecondName(GeneralData.randomAlphaNumeric(10));
        databaseProductPage.inputProductName(testProd01.getName());
        databaseProductPage.inputProductSecondaryDescription(testProd01.getSecondName());

        testProd01.setPrice1("1.90");
        databaseProductPage.inputValueOfPrice1(testProd01.getPrice1());
        testProd01.setPrice2("2.90");
        databaseProductPage.inputValueOfPrice2(testProd01.getPrice2());
        testProd01.setPrice3("3.90");
        databaseProductPage.inputValueOfPrice3(testProd01.getPrice3());
        testProd01.setPrice4("4.90");
        databaseProductPage.inputValueOfPrice4(testProd01.getPrice4());
        databaseProductPage.selectSaveButton();
        databaseProductPage.tapOnDeviceBackKey();
    }

    @Test(priority = 4)
    public void ticketTEST118SwitchNoOptionEnableDrawerOpening() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch NO option > configuration > other > settings > Enable Drawer Opening");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        ExtentTestManager.getTest().setDescription("capture test steps");
        configurationOtherPage.switchNoEnableDrawerOpeningOption();//default is YES
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectAProductByName(testProd01.getName());
        homePage.selectOperatorDisplayTotalButton();

    }

    @Test(priority = 5)
    public void ticketTEST118SwitchYesOptionEnableDrawerOpening() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch YES option > configuration > other > settings > Enable Drawer Opening");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.switchYesEnableDrawerOpeningOption();//default is YES
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectAProductByName(testProd01.getName());
        homePage.selectOperatorDisplayTotalButton();
    }

    @Test (priority = 6)
    public void ticketTEST6TheTotalAmountHasNoLimit () throws InterruptedException{
        ExtentTestManager.getTest().setDescription("back to front end, order and close a bill");
        HomePage homePage = new HomePage(driver);
        homePage.expandOnScreenKeyBoard();
        ///homePage.swipeRightToLeft(3000);
        //homePage.selectCloseBillWithoutPrinting();
        //homePage.swipeLeftToRight(3000);
        homePage.clickOnKey1();
        homePage.clickOnKey0();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectOperatorDisplayTotalButton();
    }

    @Test (priority = 7)
    public void setValueOfBillAmountLimit() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("Go to Options > Configuration > Other > Settings screen");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.inputValueOfBillAmountLimit("9.50");//input the value that be used to test
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
    }

    @Test (priority = 8)
    public void ticketTEST6TheTotalAmountLessThanLimit () throws InterruptedException{
        ExtentTestManager.getTest().setDescription("back to front end, order and close a bill");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnKey5();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectOperatorDisplayTotalButton();
    }

    @Test (priority = 9)
    public void ticketTEST6TheTotalAmountEqualLimit () throws InterruptedException{
        ExtentTestManager.getTest().setDescription("back to front end, order and close a bill");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnKey9();
        homePage.clickOnKeyDot();
        homePage.clickOnKey5();
        homePage.clickOnKey0();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectOperatorDisplayTotalButton();
    }

    @Test (priority = 10)
    public void ticketTEST6TheTotalAmountLargerThanLimit () throws InterruptedException{
        ExtentTestManager.getTest().setDescription("back to front end, order and close a bill");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnKey1();
        homePage.clickOnKey0();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectOperatorDisplayTotalButton();
        homePage.selectOkButtonInErrorMessageWhenTotalAmountExceedsLimit();
        homePage.selectOperatorDisplayCancelButton();
        homePage.selectCancelBillYesButton();
    }

    @Test (priority = 11)
    public void ticketTEST25ShownPriceListZeroCost () throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch YES option > configuration > other > settings > enable zero cost");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.switchYesEnableZeroCostOption();
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        PriceListPage priceListPage = new PriceListPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectPriceListSection();
        priceListPage.selectPriceListZero();// check the Zero price list should be shown and can be selected
    }

    @Test (priority = 12)
    public void ticketTEST25HidePriceListZeroCost () throws  InterruptedException{
        ExtentTestManager.getTest().setDescription("switch NO option > configuration > other > settings > enable zero cost");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.switchNoEnableZeroCostOption();
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        PriceListPage priceListPage = new PriceListPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectPriceListSection();
        Assert.assertFalse(priceListPage.verifyPriceListZeroIsHidden());// check the zero price list should be hidden
        priceListPage.selectPriceList1();// back to use default price list 1
    }

    @Test(priority = 13)
    public void ticketTEST16SwitchYesOptionKeypadsInCentsMode() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch YES option > configuration > other > settings > keypads in cents mode");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.switchYesKeypadsInCentsModeOption();
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        homePage.clickOnKey1();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        Assert.assertEquals("the inputed price should be 0.01","0.01",homePage.readText(By.id(homePage.homeOperatorDisplayAreaInputedPriceInfoDisplay)));
        homePage.selectOperatorDisplayTotalButton();
    }

    @Test(priority = 14)
    public void ticketTEST16SwitchNoOptionKeypadsInCentsMode() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("switch NO option > configuration > other > settings > keypads in cents mode");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.switchNoKeypadsInCentsModeOption();
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        homePage.clickOnKey1();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        Assert.assertEquals("the inputed price should be 1.00","1.00",homePage.readText(By.id(homePage.homeOperatorDisplayAreaInputedPriceInfoDisplay)));
        homePage.selectOperatorDisplayTotalButton();
    }

    @Test(priority = 15)
    public void ticketTEST10SwitchYesOptionLogoutAfterBill() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("switch YES option > configuration > other > settings > logout after bill");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.scrollToText("logout after bill");
        configurationOtherPage.switchYesLogoutAfterBillOption();
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        homePage.clickOnKey1();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectOperatorDisplayTotalButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByTechnician();// login again to verify that the app has logged out
    }

    @Test(priority = 16)
    public void ticketTEST10SwitchNoOptionLogoutAfterBill() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("switch NO option > configuration > other > settings > logout after bill");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.scrollToText("logout after bill");
        configurationOtherPage.switchNoLogoutAfterBillOption();
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        homePage.expandOnScreenKeyBoard();
        homePage.clickOnKey1();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectOperatorDisplayTotalButton();
        homePage.clickOnKey2();
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_02);
        homePage.selectOperatorDisplayTotalButton();// make more one bill to verify The app doesn't auto logout
    }

    @Test (priority = 17)
    public void ticketTEST12SwitchNoOptionResetPriceListAfterCloseBillOnFrontend() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch NO option > configuration > other > settings > reset price list after closing bill on frontend");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.scrollToElementID(configurationOtherPage.settingsResetPriceListAfterClosingBillAtFrontEndOptionId);
        configurationOtherPage.switchNoResetPriceListAfterClosingBillAtFrontEndOption();
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        homePage.expandOnScreenKeyBoard();
        Assert.assertEquals("price list 1",homePage.getCurrentPriceListInUse());// make sure the default value is price list 1
        PriceListPage priceListPage = new PriceListPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectPriceListSection();
        priceListPage.selectPriceList2();// change to use price list 2
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectAProductByName(testProd01.getName());
        homePage.selectOperatorDisplayTotalButton();
        Assert.assertEquals("price list 2",homePage.getCurrentPriceListInUse());// It must be price list 2
        Thread.sleep(5000);
    }

    @Test (priority = 18)
    public void ticketTEST12SwitchYesOptionResetPriceListAfterCloseBillOnFrontend() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch NO option > configuration > other > settings > reset price list after closing bill on frontend");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.scrollToElementID(configurationOtherPage.settingsResetPriceListAfterClosingBillAtFrontEndOptionId);
        configurationOtherPage.switchYesResetPriceListAfterClosingBillAtFrontEndOption();
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        homePage.expandOnScreenKeyBoard();
        Assert.assertEquals("price list 2",homePage.getCurrentPriceListInUse());// Make sure the current using price list is price list 2
        PriceListPage priceListPage = new PriceListPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectPriceListSection();
        priceListPage.selectPriceList2();// change to use price list 2
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectAProductByName(testProd01.getName());
        homePage.selectOperatorDisplayTotalButton();
        Assert.assertEquals("price list 1",homePage.getCurrentPriceListInUse());// App must reset price list value to price list 1
        Thread.sleep(5000);
    }

    @Test (priority = 18)
    public void ticketTEST24SwitchNoOptionResetPriceListAfterCloseBillInTable() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch NO option > configuration > other > settings > reset price list after closing bill in Table");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.switchNoResetPriceListAfterClosingBillInTableOption();
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        homePage.selectTablesTab();
        TablePlaningPage homeTablePlanPage = new TablePlaningPage(driver);
        TablePage tablePage = new TablePage(driver);
        homeTablePlanPage.selectATableByName("8");
        Assert.assertEquals("price list 1",tablePage.getCurrentPriceListInUse());//the current price list must be price list 1
        tablePage.selectPriceListMenuOption();
        tablePage.click(By.name(GeneralData.PRICE_LIST_2));
        tablePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        tablePage.selectAProductByName(testProd01.getName());
        //pay and close bill
        tablePage.swipeRightToLeftInElementDimensionFindById(3000,tablePage.orderScreenLeftSideProductGridId);
        tablePage.selectBillOption();
        tablePage.selectYesBillConfirmation();
        homePage.selectOperatorDisplayTotalButton();
        homePage.selectTablesTab();
        homeTablePlanPage.selectATableByName("8");
        Assert.assertEquals("price list 2",tablePage.getCurrentPriceListInUse());//the current price list must be price list 2
        Thread.sleep(3000);
        tablePage.selectExitButton();
        tablePage.tapOnDeviceBackKey();
    }

    @Test (priority = 19)
    public void ticketTEST24SwitchYesOptionResetPriceListAfterCloseBillInTable() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch YES option > configuration > other > settings > reset price list after closing bill in Table");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.switchYesResetPriceListAfterClosingBillInTableOption();
        configurationOtherPage.selectSaveOptionsButton();
        configurationOtherPage.tapOnDeviceBackKey();
        homePage.selectTablesTab();
        TablePlaningPage tablePlanPage = new TablePlaningPage(driver);
        TablePage tablePage = new TablePage(driver);
        tablePlanPage.selectATableByName("8");
        Assert.assertEquals("price list 2",tablePage.getCurrentPriceListInUse());//the current price list must be price list 1
        tablePage.selectPriceListMenuOption();
        tablePage.click(By.name(GeneralData.PRICE_LIST_3));
        tablePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        tablePage.selectAProductByName(testProd01.getName());
        tablePage.swipeRightToLeftInElementDimensionFindById(3000,tablePage.orderScreenLeftSideProductGridId);
        tablePage.selectBillOption();
        tablePage.selectYesBillConfirmation();
        homePage.selectOperatorDisplayTotalButton();
        homePage.selectTablesTab();
        tablePlanPage.selectATableByName("8");
        Assert.assertEquals("price list 1",tablePage.getCurrentPriceListInUse());//the current price list must be price list 2
        tablePage.selectExitButton();
        tablePlanPage.selectBackButton();
        Thread.sleep(3000);
    }
    OperatorData testOperator1 = new OperatorData();
    @Test(priority = 20)
    public void ticketTEST14SwitchYesOptionRestrictAccessToTables() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch YES option > configuration > other > settings > Restrict Access to tables");
        // login by technician account and switch YES "Restrict Access to Tables"
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.swipeBottomToTopItemToItem(2000,configurationOtherPage.settingsLogoutAfterBillOptionId,configurationOtherPage.settingsEnableZeroCostOptionId);
        configurationOtherPage.waitForVisibilityOf(By.id(configurationOtherPage.settingsRestrictAccessToTablesSwitchId));
        configurationOtherPage.tapOnItem(By.id(configurationOtherPage.settingsRestrictAccessToTablesSwitchId));
        //configurationOtherPage.switchYesRestrictAccessToTablesOption();
        configurationOtherPage.selectSaveOptionsButton();
        // create a test operator account and get its code
        ConfigurationOperatorsPage configurationOperatorsPage = new ConfigurationOperatorsPage(driver);
        configurationOperatorsPage.selectOperatorsTab();
        testOperator1.setName("test user 1");
        configurationOperatorsPage.selectAddNewOperatorButton();
        configurationOperatorsPage.inputNewOperatorName(testOperator1.getName());
        configurationOperatorsPage.selectOkButton();
        testOperator1.setCode(configurationOperatorsPage.getOperatorCode());
        char[] codeCharArray = configurationOperatorsPage.getOperatorCode().toCharArray();
        // Go to a table and order a bill
        configurationOperatorsPage.tapOnDeviceBackKey();
        TablePlaningPage tablePlaningPage = new TablePlaningPage(driver);
        TablePage tablePage = new TablePage(driver);
        homePage.selectTablesTab();
        tablePlaningPage.selectATableByName("8");
        tablePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        tablePage.selectAProductByName(testProd01.getName());
        tablePage.selectSendOrderButton();
        tablePage.selectSendFirstCourse();
        tablePlaningPage.selectBackButton();
        // log out technician account and login app by new test operator account
        homePage.expandOptionsDropdownMenu();
        homePage.selectLockOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.pressKeyByCharValue(codeCharArray[0]);
        loginPage.pressKeyByCharValue(codeCharArray[1]);
        loginPage.pressKeyByCharValue(codeCharArray[2]);
        loginPage.pressKeyByCharValue(codeCharArray[3]);
        loginPage.pressKeyOK();
        // Open the table is opened by test operator account
        homePage.selectTablesTab();
        tablePlaningPage.selectATableByName("8");
        Assert.assertEquals("operator not allowed",tablePlaningPage.getErrorMessageText());// check the error message must pop up and right
        Thread.sleep(3000);
    }
    @Test(priority = 21)
    public void ticketTEST14SwitchNoOptionRestrictAccessToTables() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("switch NO option > configuration > other > settings > Restrict Access to tables");
        //logout by test operator account
        TablePlaningPage tablePlaningPage = new TablePlaningPage(driver);
        tablePlaningPage.selectRestrictAccessTablesErrorScreenOkButton();
        tablePlaningPage.selectBackButton();
        HomePage homePage = new HomePage(driver);
        TablePage tablePage = new TablePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectLockOption();
        //login again by technician account
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByTechnician();
        // Switch NO "Restrict Access Tables"
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.swipeBottomToTopItemToItem(2000,configurationOtherPage.settingsLogoutAfterBillOptionId,configurationOtherPage.settingsEnableZeroCostOptionId);
        configurationOtherPage.waitForVisibilityOf(By.id(configurationOtherPage.settingsRestrictAccessToTablesSwitchId));
        configurationOtherPage.tapOnItem(By.id(configurationOtherPage.settingsRestrictAccessToTablesSwitchId));
        //configurationOtherPage.switchNoRestrictAccessToTablesOption();
        configurationOtherPage.selectSaveOptionsButton();
        char[] codeCharArray = testOperator1.getCode().toCharArray();
        configurationOtherPage.tapOnDeviceBackKey();
        //logout Technician account
        homePage.expandOptionsDropdownMenu();
        homePage.selectLockOption();
        //Login again by Test Operator account
        loginPage.pressKeyByCharValue(codeCharArray[0]);
        loginPage.pressKeyByCharValue(codeCharArray[1]);
        loginPage.pressKeyByCharValue(codeCharArray[2]);
        loginPage.pressKeyByCharValue(codeCharArray[3]);
        loginPage.pressKeyOK();
        // Make sure that the test operator account is able to access table is opened by Technician the pay and close bill
        homePage.selectTablesTab();
        tablePlaningPage.selectATableByName("8");
        tablePage.swipeRightToLeftInElementDimensionFindById(3000,tablePage.orderScreenLeftSideProductGridId);
        tablePage.selectBillOption();
        tablePage.selectYesBillConfirmation();
        homePage.selectOperatorDisplayTotalButton();
        Thread.sleep(3000);
    }

    @Test(priority = 22)
    public void reLoginTechnicianAccount() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("logout test operator account and login by technician account again");
        //logout by test operator account
        HomePage homePage = new HomePage(driver);
        TablePage tablePage = new TablePage(driver);
        TablePlaningPage tablePlaningPage = new TablePlaningPage(driver);
        tablePage.selectExitButton();
        tablePlaningPage.selectBackButton();
        homePage.expandOptionsDropdownMenu();
        homePage.selectLockOption();
        //login again by technician account
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByTechnician();
    }
    @Test(priority = 23)
    public void ticketTEST20SwitchYesOptionEmptyDrawerAtDailyClosing() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch YES option > configuration > other > settings > empty drawer at daily closing");
        HomePage homePage = new HomePage(driver);
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        TillFunctionsPage tillFunctionsPage = new TillFunctionsPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.swipeBottomToTopItemToItem(3000,configurationOtherPage.settingsLogoutAfterBillOptionId,configurationOtherPage.settingsBillAmountLimitOptionId );
        Thread.sleep(4000);
        configurationOtherPage.switchYesEmptyDrawerAtDailyClosingOption();
        configurationOtherPage.selectSaveOptionsButton();
        Thread.sleep(5000);
        configurationOtherPage.tapOnDeviceBackKey();
        // perform daily closing
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectDailyClosingOption();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // open till function again to check the amount of drawer
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        System.out.print("the drawer total: " + tillFunctionsPage.getDrawerTotalAmount());
        Assert.assertEquals("0.00 EUR",tillFunctionsPage.getDrawerTotalAmount());
        tillFunctionsPage.selectCloseButton();
    }
    @Test(priority = 24)
    public void ticketTEST20SwitchNoOptionEmptyDrawerAtDailyClosing() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("switch YES option > configuration > other > settings > empty drawer at daily closing");
        HomePage homePage = new HomePage(driver);
        ConfigurationOtherPage configurationOtherPage = new ConfigurationOtherPage(driver);
        TillFunctionsPage tillFunctionsPage = new TillFunctionsPage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        configurationOtherPage.goToOtherSection();
        configurationOtherPage.selectSettingsOption();
        configurationOtherPage.scrollToText("empty drawer at daily closing");
        //configurationOtherPage.swipeBottomToTopItemToItem(3000,configurationOtherPage.settingsLogoutAfterBillOptionId,configurationOtherPage.settingsBillAmountLimitOptionId );
        configurationOtherPage.switchNoEmptyDrawerAtDailyClosingOption();
        configurationOtherPage.selectSaveOptionsButton();
        Thread.sleep(5000);
        configurationOtherPage.tapOnDeviceBackKey();
        //Pay and close a bill in front end
        homePage.selectADepartmentByName(GeneralData.DEFAULT_DEPT_01);
        homePage.selectAProductByName(testProd01.getName());
        homePage.selectOperatorDisplayTotalButton();
        Thread.sleep(5000);
        // perform daily closing
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        tillFunctionsPage.selectDailyClosingOption();
        homePage.selectOkInClosureConfirmation();
        homePage.selectNoInReportConfirmation();
        // open till function again to check the amount of drawer
        homePage.expandOptionsDropdownMenu();
        homePage.selectTillFunctionsOption();
        System.out.print("the drawer total: " + tillFunctionsPage.getDrawerTotalAmount());
        Assert.assertNotSame("should not be same","0.00 EUR",tillFunctionsPage.getDrawerTotalAmount());
    }
}