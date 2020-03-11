package scenarios;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.Assert;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
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
import java.lang.Process;
import java.lang.Runnable;


public class UserGeneralScenarios extends AndroidSetup {

    // test data for create a test product

    DatabaseProductPage databaseProductPage = new DatabaseProductPage(driver);


    /////////////////////////////////////

    // test data for creating a test department
    DepartmentData testDept01 = new DepartmentData();

    //////////////////////////////////
    // test data for creating sample test products
    ProductData testProd01 = new ProductData();
    ProductData testProd02 = new ProductData();
    ProductData testProd03 = new ProductData();
    GeneralData data1 = new GeneralData();
    OperatorData testOperator1 = new OperatorData();

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

    @Test(priority = 1)
    public void loginByTechnicianAccount() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("Login by Technician account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByTechnician();
    }
    /*
    @Test(priority = 2)
    public void importTestExcelDataFile() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("Go to Database | Pricelist section");
        HomePage homePage = new HomePage(driver);
        homePage.selectOkInDemoWarningScreen();
        homePage.expandOptionsDropdownMenu();
        homePage.selectDatabasesSection();
        DatabaseManagementPage databaseManagementPage = new DatabaseManagementPage(driver);
        databaseManagementPage.selectDatabasesManagementTab();
        databaseManagementPage.selectImportDataButton();
        databaseManagementPage.scrollToText("db_20180814_054722_40603200.xls");// the data excel file name
        databaseManagementPage.click(By.name("db_20180814_054722_40603200.xls"));// the data excel file name
        Thread.sleep(20000);
        databaseManagementPage.tapOnDeviceBackKey();
        Thread.sleep(10000);
    }
     */

    @Test (priority = 2)
    public void setupPrinter() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("setup printer by ip address");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        ConfigurationPrintersPage configurationPrintersPage = new ConfigurationPrintersPage(driver);
        configurationPrintersPage.goToPrinterSection();
        configurationPrintersPage.selectPrinter(PrinterData.PRINTER_BILL);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);
        configurationPrintersPage.selectSaveButton();
        configurationPrintersPage.selectPrinter(PrinterData.PRINTER_DOC);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);
        configurationPrintersPage.selectSaveButton();
        configurationPrintersPage.selectPrinter(PrinterData.PRINTER_FOOD);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);
        configurationPrintersPage.selectSaveButton();
        configurationPrintersPage.selectPrinter(PrinterData.PRINTER_BAR);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);
        configurationPrintersPage.selectSaveButton();
        configurationPrintersPage.selectPrinter(PrinterData.PRINTER_KITCHEN);
        configurationPrintersPage.inputPrinterIp(GeneralData.PRINTER_IP);
        configurationPrintersPage.selectSaveButton();
        Thread.sleep(5000);
        configurationPrintersPage.tapOnDeviceBackKey();
    }

    @Test(priority = 4)
    public void createDepartment() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("Create a test department");

        HomePage homePage = new HomePage(driver);
        DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);
        ColorPalette colorPalette = new ColorPalette(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectDatabasesSection();

        // Create a department
        databaseDepartmentPage.selectPricelistTab();
        databaseDepartmentPage.goToDepartmentCreatingForm();

        databaseDepartmentPage.swipeBottomToTop(2000);
        databaseDepartmentPage.callColorPallete();
        colorPalette.pickForestGreenColor();

        databaseDepartmentPage.checkShowVariants();
        databaseDepartmentPage.checkTicketing();

        databaseDepartmentPage.callPrintersMenu();// need re-check the dimension of printer button
        databaseDepartmentPage.selectPrinter(PrinterData.PRINTER_BAR);
        databaseDepartmentPage.callSecondPrinterMenu();
        databaseDepartmentPage.selectPrinter(PrinterData.PRINTER_FOOD);

        testDept01.setPrice(GeneralData.randomNumeric(2));
        testDept01.setMaxPrice(GeneralData.randomNumeric(3));
        databaseDepartmentPage.inputMaxPriceValue(testDept01.getMaxPrice());
        databaseDepartmentPage.inputPriceValue(testDept01.getPrice());

        // Select value for field VAT 1
        databaseDepartmentPage.showVATMenu(GeneralData.VAT_PLACEHOLDER);
        databaseDepartmentPage.selectValueForVAT(GeneralData.VAT_DEFAULT_VALUE_01);

        //Select value for field VAT 2
        databaseDepartmentPage.showVATMenu(GeneralData.VAT_PLACEHOLDER);
        databaseDepartmentPage.selectValueForVAT(GeneralData.VAT_DEFAULT_VALUE_02);

        //Select value for field VAT 3
        databaseDepartmentPage.showVATMenu(GeneralData.VAT_PLACEHOLDER);
        databaseDepartmentPage.selectValueForVAT(GeneralData.VAT_DEFAULT_VALUE_03);

        databaseDepartmentPage.swipeTopToBottom(2000);
        testDept01.setName("testDept01");
        testDept01.setSecondName(GeneralData.randomAlphaNumeric(10));
        databaseDepartmentPage.inputDepartmentName(testDept01.getName());
        databaseDepartmentPage.inputSecondaryDescription(testDept01.getSecondName());
        //databaseDepartmentPage.clearCategoryValue();
        //databaseDepartmentPage.inputCategoryValue(category_Id);
        Thread.sleep(2000);
        databaseDepartmentPage.selectSaveButton();
        //databaseDepartmentPage.tapOnDeviceBackKey();
    }

    @Test(priority = 5)
    public void createProduct01WithoutPrice() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("create a new product without price");
        DatabaseProductPage databaseProductPage = new DatabaseProductPage(driver);

        //precondition
        DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);
        databaseDepartmentPage.scrollToText(testDept01.getName());
        databaseDepartmentPage.selectDepartment(testDept01.getName());

        databaseProductPage.goToProductCreatingForm();

        testProd01.setName("testProd01");
        testProd01.setSecondName(GeneralData.randomAlphaNumeric(10));
        databaseProductPage.inputProductName(testProd01.getName());
        databaseProductPage.inputProductSecondaryDescription(testProd01.getSecondName());

        databaseProductPage.selectSaveButton();

    }

    @Test(priority = 6)
    public void createProduct02HasPrices() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("create a new product");
        DatabaseProductPage databaseProductPage = new DatabaseProductPage(driver);

        //precondition
        DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);
        databaseDepartmentPage.selectDepartment(testDept01.getName());
        databaseProductPage.goToProductCreatingForm();

        testProd02.setName("testProd02");
        testProd02.setSecondName(GeneralData.randomAlphaNumeric(10));
        databaseProductPage.inputProductName(testProd02.getName());
        databaseProductPage.inputProductSecondaryDescription(testProd02.getSecondName());

        testProd02.setPrice1("1.90");
        databaseProductPage.inputValueOfPrice1(testProd02.getPrice1()) ;
        //databaseProductPage.inputValueForPriceOption2(testProd02.price2);
        //databaseProductPage.inputValueForPriceOption3(testProd02.price3);
        //databaseProductPage.inputValueForPriceOption4(testProd02.price4);
        databaseProductPage.selectSaveButton();
    }

    @Test(priority = 7)
    public void createProduct03HasPrices() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("create a new product");
        DatabaseProductPage databaseProductPage = new DatabaseProductPage(driver);

        //precondition
        DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);
        databaseDepartmentPage.selectDepartment(testDept01.getName());
        databaseProductPage.goToProductCreatingForm();

        testProd03.setName("testProd03");
        testProd03.setSecondName(GeneralData.randomAlphaNumeric(10));
        databaseProductPage.inputProductName(testProd03.getName());
        databaseProductPage.inputProductSecondaryDescription(testProd03.getSecondName());

        testProd03.setPrice1(GeneralData.randomNumeric(1)+"."+GeneralData.randomNumeric(2));
        databaseProductPage.inputValueOfPrice1(testProd03.getPrice1());
        databaseProductPage.selectSaveButton();
        databaseDepartmentPage.tapOnDeviceBackKey();
    }

    @Test(priority = 8)
    public void orderABillBySelectProduct() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("do a bill by select a product");
        DatabaseProductPage databaseProductPage = new DatabaseProductPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.scrollToText(testDept01.getName());
        homePage.selectADepartmentByName(testDept01.getName());
        homePage.selectAProductByName(testProd01.getName());
        homePage.selectADepartmentByName(testDept01.getName());
        homePage.selectAProductByName(testProd02.getName());
        homePage.clickOnAnItemInHomeOperatorDisplayArea(testProd01.getName());// to call a drop-down menu for editing the ordered items
        homePage.click(By.name(homePage.homeOperatorProductDropMenuDeleteOption));
        Thread.sleep(5000);
        homePage.selectOperatorDisplayTotalButton();
    }

    /*
    @Test(priority = 9)
    public void demoOpenATable() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("try to open a new table order");
        HomePage homePage = new HomePage(driver);
        homePage.selectTablesTab();
        TablePlaningPage tablePlaningPage = new TablePlaningPage(driver);
        TablePage tablePage = new TablePage(driver);
        tablePlaningPage.selectATableByName("2");
        //tablePage.selectPriceListMenuOption();
        //tablePage.click(By.name(GeneralData.PRICE_LIST_2));
        tablePage.selectADepartmentByName(DepartmentData.beer);
        tablePage.selectAProductByName(DepartmentData.BEER_Carlsberg);
        tablePage.selectAProductByName(DepartmentData.BEER_Corona);
        //tablePage.selectSendOrderButton();
        //tablePage.selectSendFirstCourse();
        //tablePlaningPage.selectATableByName("2");
        tablePage.swipeRightToLeftInElementDimensionFindById(1000,tablePage.orderScreenLeftSideProductGridId);
        tablePage.selectSplitOption();
        tablePage.selectAProductByName(DepartmentData.BEER_Carlsberg);
        tablePage.selectBillOption();
        homePage.selectOperatorDisplayTotalButton();

    }


    @Test(priority = 3)
    public void loginAfterRebootDevice() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("login after reboot device");
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.loginByTechnician();
    }
    */
}
