package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DatabaseDepartmentPage;
import pages.DatabaseVariantPage;
import pages.LoginPage;
import utils.ExtentReports.ExtentTestManager;


public class DatabaseReturnableTest extends AndroidSetup{
    @Parameters(value = "apkFilePath")
    @BeforeClass
    public void setUp(String apkFilePath) throws Exception {
        prepareAndroidForAppium(apkFilePath);
    }
    // test data for create a test product

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm0123456789";
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
    private static final String NUMERIC_STRING = "0123456789";
    public static String randomNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

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

        loginPage.loginByTechnician();

    }
}
