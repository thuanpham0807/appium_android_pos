package scenarios;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ExtentReports.ExtentTestManager;

public class LoginTest extends AndroidSetup {

    @Parameters(value = "apkFilePath")
    @BeforeClass
    public void setUp(String apkFilePath) throws Exception {
        prepareAndroidForAppium(apkFilePath);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test (priority = 1)
    public void TC_LG001() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("check all mandatory elements must be present");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue("top logo",loginPage.isElementPresent(By.id(loginPage.topLogoId)));
        Assert.assertTrue("key 0", loginPage.isElementPresent(By.id(loginPage.loginFormKeyNumber0Id)));
        Assert.assertTrue("key 1", loginPage.isElementPresent(By.id(loginPage.loginFormKeyNumber1Id)));
        Assert.assertTrue("key 2", loginPage.isElementPresent(By.id(loginPage.loginFormKeyNumber2Id)));
        Assert.assertTrue("key 3", loginPage.isElementPresent(By.id(loginPage.loginFormKeyNumber3Id)));
        Assert.assertTrue("key 4", loginPage.isElementPresent(By.id(loginPage.loginFormKeyNumber4Id)));
        Assert.assertTrue("key 5", loginPage.isElementPresent(By.id(loginPage.loginFormKeyNumber5Id)));
        Assert.assertTrue("key 6", loginPage.isElementPresent(By.id(loginPage.loginFormKeyNumber6Id)));
        Assert.assertTrue("key 7", loginPage.isElementPresent(By.id(loginPage.loginFormKeyNumber7Id)));
        Assert.assertTrue("key 8", loginPage.isElementPresent(By.id(loginPage.loginFormKeyNumber8Id)));
        Assert.assertTrue("key 9", loginPage.isElementPresent(By.id(loginPage.loginFormKeyNumber9Id)));
        Assert.assertTrue("key OK", loginPage.isElementPresent(By.id(loginPage.loginFromKeyOKId)));
        Assert.assertTrue("key Cancel", loginPage.isElementPresent(By.id(loginPage.loginFormKeyCancelId)));
        Assert.assertNotNull(loginPage.readText(By.id(loginPage.versionLabelId)));
        Assert.assertNotNull(loginPage.readText(By.id(loginPage.posIdLabelId)));
        Assert.assertNotNull(loginPage.readText(By.id(loginPage.clockTimeId)));
        Assert.assertNotNull(loginPage.readText(By.id(loginPage.clockDateId)));
    }

    @Test (priority = 2)
    public void TC_LG002WithTechnician() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("happy case: check login/logout by 2 default accounts Tech and Admin");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);//technician
        loginPage.loginByTechnician();
        Assert.assertEquals("Operator Info name: ","technician",homePage.getLoginInfoHeader());
    }

    @Test (priority = 3)
    public void TC_LG002WithAdmin() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("happy case: check login/logout by 2 default accounts Tech and Admin");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);//technician
        loginPage.logOut();
        loginPage.loginByAdmin();
        Assert.assertEquals("Operator Info name: ","administrator",homePage.getLoginInfoHeader());
    }

    @Test (priority = 4)
    public void TC_LG004() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("negative case: login by blank password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logOut();
        // Select OK without inputting password
        loginPage.pressKeyOK();
        // to check user still stay in login screen if any element which in this screen still be displayed
        Assert.assertTrue("key OK", loginPage.isElementPresent(By.id(loginPage.loginFromKeyOKId)));
    }

    @Test (priority = 5)
    public void TC_LG003() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("negative case: login by blank password");
        LoginPage loginPage = new LoginPage(driver);
        // input password keys by keys
        loginPage.pressKeyNumber0();
        loginPage.pressKeyNumber9();
        loginPage.pressKeyNumber1();
        loginPage.pressKeyOK();
        // to check user still stay in login screen if any element which in this screen still be displayed
        Assert.assertTrue("key OK", loginPage.isElementPresent(By.id(loginPage.loginFromKeyOKId)));
    }

    @Test (priority = 6)
    public void TC_LG0051stStep() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("multiple tap on top logo to show alert 'one step from reset'");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue("top logo",loginPage.isElementPresent(By.id(loginPage.topLogoId)));
        loginPage.tapOnTopLogoInTimes(5);
    }
    @Test (priority = 7)
    public void TC_LG005FinalStep() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("multiple tap on top logo to reset password of Technician");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue("top logo",loginPage.isElementPresent(By.id(loginPage.topLogoId)));
        loginPage.tapOnTopLogoInTimes(15);
    }

    @Test (priority = 8)
    public void TC_LG006() throws InterruptedException {

        ExtentTestManager.getTest().setDescription("Tap and hold on Version label to export logfile");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertNotNull(loginPage.readText(By.id(loginPage.versionLabelId)));
        loginPage.tapAndHoldOnVersionLabel();
    }

}