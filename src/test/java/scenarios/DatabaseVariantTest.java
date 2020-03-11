package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DatabaseDepartmentPage;
import pages.DatabaseVariantPage;
import pages.LoginPage;
import utils.ExtentReports.ExtentTestManager;


public class DatabaseVariantTest extends AndroidSetup{
    @Parameters(value = "apkFilePath")
    @BeforeClass
    public void setUp(String apkFilePath) throws Exception {
        prepareAndroidForAppium(apkFilePath);
    }
    // test data for create a test product

    // end of define test data


    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();

    }

    @Test (priority = 1)
    public void preconditionTest() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("Login then create a test department and preselect it");

        DatabaseVariantPage databaseVariantPage = new DatabaseVariantPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DatabaseDepartmentPage databaseDepartmentPage = new DatabaseDepartmentPage(driver);
        // login in app
        loginPage.loginByTechnician();

    }
}
