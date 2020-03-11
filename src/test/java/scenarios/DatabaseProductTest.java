package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DatabaseDepartmentPage;
import pages.DatabaseProductPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExtentReports.ExtentTestManager;


public class DatabaseProductTest extends AndroidSetup{
    @Parameters(value = "apkFilePath")
    @BeforeClass
    public void setUp(String apkFilePath) throws Exception {
        prepareAndroidForAppium(apkFilePath);
    }
    // test data for create a test product

    //////////////////////////////////////////////////

    // test data for creating a test department

    //////////////////////////////////

    ///// Colors locations in Pallete///////

    // end of define test data


    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();

    }

    @Test (priority = 1)
    public void preconditionTest() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("Login then create a test department and preselect it");

        DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.loginByTechnician();
        homePage.expandOptionsDropdownMenu();
        homePage.selectDatabasesSection();

        // Create and preselect a department
    }
    @Test (priority = 2)
    public void createDemoNewProduct() throws InterruptedException{


        ExtentTestManager.getTest().setDescription("create a new product");
        DatabaseProductPage databaseProductPage = new DatabaseProductPage(driver);

        // define test data for product

    }
}
