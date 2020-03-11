package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ExtentReports.ExtentTestManager;
import pages.DemoLoginPage;

public class DemoLoginTest extends AndroidSetup{

    @Parameters(value = "apkFilePath")
    @BeforeClass
    public void setUp(String apkFilePath) throws Exception {
        prepareAndroidForAppium(apkFilePath);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();

    }

    @Test (priority = 1, description = "this is my first test")
    public void loginWithRightPass() throws InterruptedException {

        DemoLoginPage demoLoginPage = new DemoLoginPage(driver);
        demoLoginPage.clickOnKey1();
        demoLoginPage.clickOnkey2();
    }
}
