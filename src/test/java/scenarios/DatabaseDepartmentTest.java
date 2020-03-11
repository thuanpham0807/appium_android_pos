package scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DatabaseDepartmentPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExtentReports.ExtentTestManager;
import utils.TestDataManagement.DepartmentData;
import utils.TestDataManagement.GeneralData;


public class DatabaseDepartmentTest extends AndroidSetup{

    @Parameters(value = "apkFilePath")
    @BeforeClass
    public void setUp(String apkFilePath) throws Exception {
        prepareAndroidForAppium(apkFilePath);
    }
    // define test data

    // test data for creating a test department
    DepartmentData autoTestDept01 = new DepartmentData();
    DepartmentData autoTestDept02 = new DepartmentData();

    //////////////////////////////////
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();

    }

    @Test (priority = 1)
    public void preconditionTest() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("Login with right password of technician account");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.loginByTechnician();
        homePage.expandOptionsDropdownMenu();
        homePage.selectDatabasesSection();
    }
    @Test (priority = 2)
    public void createNewDepartment() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("this is a draft test case to create a new department");
        DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);

        databaseDepartmentPage.goToDepartmentCreatingForm();

        ////////////fill data in form/////////////////////////
        databaseDepartmentPage.swipeBottomToTop(2000);
        Thread.sleep(2000);

        databaseDepartmentPage.checkVisible();
        databaseDepartmentPage.checkShowVariants();
        databaseDepartmentPage.checkTicketing();

        databaseDepartmentPage.callPrintersMenu();
        databaseDepartmentPage.selectPrinter(GeneralData.DEFAULT_PRINTER_01);
        databaseDepartmentPage.callSecondPrinterMenu();
        databaseDepartmentPage.selectPrinter(GeneralData.DEFAULT_PRINTER_02);

        autoTestDept01.setMaxPrice(GeneralData.randomNumeric(2));
        autoTestDept01.setPrice(GeneralData.randomNumeric(2));
        databaseDepartmentPage.inputMaxPriceValue(autoTestDept01.getMaxPrice());
        databaseDepartmentPage.inputPriceValue(autoTestDept01.getPrice());

        // Select value for field VAT 1
        databaseDepartmentPage.showVATMenu(GeneralData.VAT_PLACEHOLDER);
        databaseDepartmentPage.selectValueForVAT(GeneralData.VAT_DEFAULT_VALUE_02);
        //driver.hideKeyboard();

        //Select value for field VAT 2
        databaseDepartmentPage.showVATMenu(GeneralData.VAT_PLACEHOLDER);
        databaseDepartmentPage.selectValueForVAT(GeneralData.VAT_DEFAULT_VALUE_03);

        //Select value for field VAT 3
        databaseDepartmentPage.showVATMenu(GeneralData.VAT_PLACEHOLDER);
        databaseDepartmentPage.selectValueForVAT(GeneralData.VAT_DEFAULT_VALUE_01);

        databaseDepartmentPage.swipeTopToBottom(2000);

        autoTestDept01.setName(GeneralData.randomAlphaNumeric(10));
        databaseDepartmentPage.inputDepartmentName(autoTestDept01.getName());
        autoTestDept01.setSecondName(GeneralData.randomAlphaNumeric(10));
        databaseDepartmentPage.inputSecondaryDescription(autoTestDept01.getSecondName());

        //databaseDepartmentPage.clearCategoryValue();
        //databaseDepartmentPage.inputCategoryValue(categoryId);
        ////////////////////////////End of fill data in form/////////////////////////////////////////////////////
        Thread.sleep(5000);
        databaseDepartmentPage.selectSaveButton();
    }
    @Test(priority = 3)
    public void createChildDepartment() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("this is a draft test case to create a new department");
        DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);
        ////////// Create child category
        databaseDepartmentPage.goToDepartmentCreatingForm();
        ////////////fill data in form/////////////////////////
        databaseDepartmentPage.swipeBottomToTop(2000);
        Thread.sleep(2000);

        // change color
        databaseDepartmentPage.checkShowVariants();
        databaseDepartmentPage.checkTicketing();

        databaseDepartmentPage.callPrintersMenu();
        databaseDepartmentPage.selectPrinter(GeneralData.DEFAULT_PRINTER_01);
        autoTestDept02.setPrice(GeneralData.randomNumeric(2)+"."+GeneralData.randomNumeric(2));
        databaseDepartmentPage.inputPriceValue(autoTestDept02.getPrice());

        // Select value for field VAT 1
        databaseDepartmentPage.showVATMenu(GeneralData.VAT_PLACEHOLDER);
        databaseDepartmentPage.selectValueForVAT(GeneralData.VAT_DEFAULT_VALUE_02);
        databaseDepartmentPage.scrollToText("description");

        autoTestDept02.setName(GeneralData.randomAlphaNumeric(10));
        databaseDepartmentPage.inputDepartmentName(autoTestDept02.getName());
        autoTestDept02.setSecondName(GeneralData.randomAlphaNumeric(10));
        databaseDepartmentPage.inputSecondaryDescription(autoTestDept02.getSecondName());

        databaseDepartmentPage.callParentCategoriesMenu();
        databaseDepartmentPage.selectAValidParentByName(autoTestDept01.getName());

        //databaseDepartmentPage.clearCategoryValue();
        //databaseDepartmentPage.inputCategoryValue(categoryId);
        ////////////////////////////End of fill data in form/////////////////////////////////////////////////////
        Thread.sleep(5000);
        databaseDepartmentPage.selectSaveButton();
    }
    @Test (priority = 4)
    public void createLoopDepartment() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("Create a test department");
        String[] testDeptlist = new String[100];
        for (int i=0;i<10;i++){
            if (i==0){
                String testDept = String.valueOf(i)+ "test " + GeneralData.randomAlphaNumeric(7);
                testDeptlist[i] = testDept;
                // Create a department
                DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);
                Thread.sleep(5000);
                databaseDepartmentPage.goToDepartmentCreatingForm();

                databaseDepartmentPage.swipeBottomToTop(2000);
                Thread.sleep(2000);

                // Select value for field VAT 1
                databaseDepartmentPage.showVATMenu(GeneralData.VAT_PLACEHOLDER);
                databaseDepartmentPage.selectValueForVAT(GeneralData.VAT_DEFAULT_VALUE_02);

                databaseDepartmentPage.swipeTopToBottom(2000);

                databaseDepartmentPage.inputDepartmentName(testDeptlist[i]);
                //databaseDepartmentPage.inputSecondaryDescription(secondDescription);
                Thread.sleep(2000);
                databaseDepartmentPage.selectSaveButton();
            } else {
                String testDept = String.valueOf(i)+ "test " + GeneralData.randomAlphaNumeric(7);
                testDeptlist[i] = testDept;
                // Create a department
                DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);
                Thread.sleep(5000);
                databaseDepartmentPage.goToDepartmentCreatingForm();

                databaseDepartmentPage.swipeBottomToTop(2000);
                Thread.sleep(2000);

                // Select value for field VAT 1
                databaseDepartmentPage.showVATMenu(GeneralData.VAT_PLACEHOLDER);
                databaseDepartmentPage.selectValueForVAT(GeneralData.VAT_DEFAULT_VALUE_02);

                databaseDepartmentPage.swipeTopToBottom(2000);

                databaseDepartmentPage.inputDepartmentName(testDeptlist[i]);
                databaseDepartmentPage.callParentCategoriesMenu();
                String a = testDeptlist[i-1];
                databaseDepartmentPage.selectAValidParentByName(a);
                Thread.sleep(2000);
                databaseDepartmentPage.selectSaveButton();
            }
        }
    }
}
