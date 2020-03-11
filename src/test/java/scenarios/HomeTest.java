package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ExtentReports.ExtentTestManager;

public class HomeTest extends AndroidSetup {

    @Parameters(value = "apkFilePath")
    @BeforeClass
    public void setUp(String apkFilePath) throws Exception {
        prepareAndroidForAppium(apkFilePath);
    }


    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();

    }

    @Test (priority =  1)
    public void preconditionTest() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("Login with right password of technician account");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginByTechnician();
    }
    @Test (priority = 2)
    public void navigateToSignOut() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("From Home press Back key to call Logout form");
        HomePage homePage = new HomePage(driver);
        homePage.callSignOutForm();
        homePage.verifyLogoutFormTitle("POS logout");
        homePage.cancelLogout();
    }
    @Test (priority = 3)
    public void navigateToDatabases() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("From Home navigate to Databases section");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectDatabasesSection();
        homePage.tapOnDeviceBackKey();
        Thread.sleep(5000);
    }
    @Test (priority = 4)
    public void navigateToConfiguration() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("From Home navigate to Configuration section");
        HomePage homePage = new HomePage(driver);
        homePage.expandOptionsDropdownMenu();
        homePage.selectConfigurationSection();
        homePage.tapOnDeviceBackKey();
        Thread.sleep(5000);
    }
    @Test (priority = 5)
    public void demoAction() throws InterruptedException{
        ExtentTestManager.getTest().setDescription("this is for demo");
        HomePage homePage = new HomePage(driver);
        //homePage.swipeRightToLeft(2000);
        //homePage.swipeLeftToRight(2000);
        //homePage.longPressADepartment("DEPT.4");
        homePage.selectADepartmentByName("DEPT.4");
        homePage.selectFavoriteStarIcon();
        homePage.callFontSizeConfig();
        homePage.selectCategoriesInFontsizeMenu();
        homePage.increaseFontsize(10);
        Thread.sleep(5000);
        homePage.tapOnPoint(600,700);// click to exit fontsize config menu
        Thread.sleep(5000);
    }
}
