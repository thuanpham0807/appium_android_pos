package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class LoginPage extends BasePage {


    ///element locators
    public String topLogoId = "top_logo";
    public String versionLabelId  = "version_label";
    public void tapAndHoldOnVersionLabel(){longPress(By.id(versionLabelId));}
    public String posIdLabelId = "id_label";
    public String clockDateId = "clock_date";
    public String clockTimeId = "clock_time";
    public String wallpaperIconId = "background_options";
    public String passwordFieldId = "pin_input";//id
    public String loginFromKeyOKId = "keyOk";
    public String loginFormKeyCancelId = "keyCanc";
    public String loginFormKeyNumber0Id = "key0";//id
    public String loginFormKeyNumber1Id = "key1";//id
    public String loginFormKeyNumber2Id = "key2";//id
    public String loginFormKeyNumber3Id = "key3";//id
    public String loginFormKeyNumber4Id = "key4";//id
    public String loginFormKeyNumber5Id = "key5";//id
    public String loginFormKeyNumber6Id = "key6";//id
    public String loginFormKeyNumber7Id = "key7";//id
    public String loginFormKeyNumber8Id = "key8";//id
    public String loginFormKeyNumber9Id = "key9";//id
    public String manualRestartConfirmationOkButtonId = "button3";

    public String logfileCloseBtnXpath = "//android.widget.Button[@text='close']";
    public void selectClose() {click(By.xpath(logfileCloseBtnXpath));}
    public String logfileEmailBtnXpath = "//android.widget.Button[@text='email']";
    public void selectEmail() {click(By.xpath(logfileEmailBtnXpath));}

    // Wallpaper image grid items location

    // the condition for check login process is ok
    public String options_Button = "pos_toolbar_settings_button";
    public String logout_Form = "alertTitle";
    // the element locators for logout function

    public String logout_Form_Cancel_btn = "cancel";
    public String logout_Form_Ok_Btn = "OK";

    public LoginPage(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }


    public void loginByTechnician(){
        click(By.id(loginFormKeyCancelId));
        click(By.id(loginFormKeyNumber1Id));
        click(By.id(loginFormKeyNumber2Id));
        click(By.id(loginFormKeyNumber3Id));
        click(By.id(loginFormKeyNumber4Id));
        click(By.id(loginFromKeyOKId));
    }

    public void loginByAdmin(){
        click(By.id(loginFormKeyCancelId));
        click(By.id(loginFormKeyNumber9Id));
        click(By.id(loginFormKeyNumber9Id));
        click(By.id(loginFormKeyNumber9Id));
        click(By.id(loginFormKeyNumber9Id));
        click(By.id(loginFromKeyOKId));
    }

    public void verifyLoginPass (String expectedText){
        Assert.assertEquals(readText(By.id(options_Button)), expectedText);
    }

    public void verifyLogoutFormTitle (String expectedText){
        Assert.assertEquals(readText(By.id(logout_Form)),expectedText);
    }

    public void logOut(){
        tapOnDeviceBackKey();
        selectOkInConfirmation();
    }

    public void tapOnTopLogo() { click(By.id(topLogoId));}
    public void tapOnTopLogoLocation()
    {
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int y = size.height/10;
        tapOnPoint(x,y);
    }

    public void tapOnTopLogoInTimes(int time){
        for (int i = 0;i <= time; i++) {
            tapOnTopLogoLocation();
        }
        }
    public void pressKeyNumber0(){click(By.id(loginFormKeyNumber0Id));}
    public void pressKeyNumber1(){click(By.id(loginFormKeyNumber1Id));}
    public void pressKeyNumber2(){click(By.id(loginFormKeyNumber2Id));}
    public void pressKeyNumber3(){click(By.id(loginFormKeyNumber3Id));}
    public void pressKeyNumber4(){click(By.id(loginFormKeyNumber4Id));}
    public void pressKeyNumber5(){click(By.id(loginFormKeyNumber5Id));}
    public void pressKeyNumber6(){click(By.id(loginFormKeyNumber6Id));}
    public void pressKeyNumber7(){click(By.id(loginFormKeyNumber7Id));}
    public void pressKeyNumber8(){click(By.id(loginFormKeyNumber8Id));}
    public void pressKeyNumber9(){click(By.id(loginFormKeyNumber9Id));}
    public void pressKeyOK(){click(By.id(loginFromKeyOKId));}
    public void pressKeycancel(){click(By.id(loginFormKeyCancelId));}

    public void selectManualRestartConfirmationOkButton(){
        click(By.id(manualRestartConfirmationOkButtonId));}

    public void loginByGetCodeOfOperator(char[] passArray){

        for (int i = 0; i<passArray.length;i++)
        {
            char value = passArray[i];
            switch(value){
                case '0':
                    pressKeyNumber0();
                    break;
                case '1':
                    pressKeyNumber1();
                    break;
                case '2':
                    pressKeyNumber2();
                    break;
                case '3':
                    pressKeyNumber3();
                    break;
                case '4':
                    pressKeyNumber4();
                    break;
                case '5':
                    pressKeyNumber5();
                    break;
                case '6':
                    pressKeyNumber6();
                    break;
                case '7':
                    pressKeyNumber7();
                    break;
                case '8':
                    pressKeyNumber8();
                    break;
                case '9':
                    pressKeyNumber9();
                    break;
            }
        }
        click(By.id(loginFromKeyOKId));
    }
    public void pressKeyByCharValue(char value){
        switch(value){
            case '0':
                pressKeyNumber0();
                break;
            case '1':
                pressKeyNumber1();
                break;
            case '2':
                pressKeyNumber2();
                break;
            case '3':
                pressKeyNumber3();
                break;
            case '4':
                pressKeyNumber4();
                break;
            case '5':
                pressKeyNumber5();
                break;
            case '6':
                pressKeyNumber6();
                break;
            case '7':
                pressKeyNumber7();
                break;
            case '8':
                pressKeyNumber8();
                break;
            case '9':
                pressKeyNumber9();
                break;
        }
    }
}
