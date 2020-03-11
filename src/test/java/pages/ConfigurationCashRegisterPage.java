package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class ConfigurationCashRegisterPage extends BasePage {

    public ConfigurationCashRegisterPage(AndroidDriver<AndroidElement> driver){
        super (driver);
    }
    // define elements and methods for Fiscal Information section
    public String fiscalInfoViewId = "vp_list_fiscal";
    public String cashRegisterTabName = "cash register";
    public String fiscalInformationSectionName = "fiscal information";
    public String fiscalInformationSectionXpath = "//android.widget.TextView[@text = 'fiscal information' and @index = '1']";
    public String fiscalInfoVendorNameFieldId = "fiscal_info_vendor_name";
    public String fiscalInfoStreetNumberFieldId = "fiscal_info_street_number";
    public String fiscalInfoStreetNameFieldId = "fiscal_info_street_name";
    public String fiscalInfoCityNameFieldId = "fiscal_info_city_name";
    public String fiscalInfoSiretFieldId = "fiscal_info_siret";
    public String fiscalInfoNafFieldId = "fiscal_info_naf";
    public String fiscalInfoTvaFieldId = "fiscal_info_tva";
    public String fiscalInfoSaveButtonId = "fiscal_info_save_btn";
    public String fiscalInfoWarningOkButtonId = "button1";
    public String fiscalInfoWarningCancelButtonId = "button2";
    public String fiscalizationMachineConfirmationOkButtonId = "custom_alert_positive_button";
    public String fiscalInfoPreviousButtonId = "btn_fiscal_info_pre";
    public String fiscalInfoNextButtonId = "btn_fiscal_info_next";


    public void selectCashRegisterTab (){click(By.name(cashRegisterTabName));}
    public void selectFiscalInformationSection () { click(By.xpath(fiscalInformationSectionXpath)); }
    public void selectFiscalInfoSaveButton (){click(By.id(fiscalInfoSaveButtonId));}
    public void inputDataFiscalInfoVendorName (String textValue){writeText(By.id(fiscalInfoVendorNameFieldId),textValue);}
    public void clearDataFiscalInfoVendorName (){clearText(By.id(fiscalInfoVendorNameFieldId));}
    public void inputDataFiscalInfoStreetNumber (String textValue){writeText(By.id(fiscalInfoStreetNumberFieldId),textValue);}
    public void clearDataFiscalInfoStreetNumber (){clearText(By.id(fiscalInfoStreetNumberFieldId));}
    public void inputDataFiscalInfoStreetName(String textValue){writeText(By.id(fiscalInfoStreetNameFieldId),textValue);}
    public void clearDataFiscalInfoStreetName(){clearText(By.id(fiscalInfoStreetNameFieldId));}
    public void inputDataFiscalInfoCityName(String textValue){writeText(By.id(fiscalInfoCityNameFieldId),textValue);}
    public void clearDataFiscalInfoCityName(){clearText(By.id(fiscalInfoCityNameFieldId));}
    public void inputDataFiscalInfoSiretNumber(String textValue){writeText(By.id(fiscalInfoSiretFieldId),textValue);}
    public void clearDataFiscalInfoSiretNumber(){clearText(By.id(fiscalInfoSiretFieldId));}
    public void inputDataFiscalInfoNafNumber(String textValue){writeText(By.id(fiscalInfoNafFieldId),textValue);}
    public void clearDataFiscalInfoNafNumber(){clearText(By.id(fiscalInfoNafFieldId));}
    public void inputDataFiscalInfoTvaNumber(String textValue){writeText(By.id(fiscalInfoTvaFieldId),textValue);}
    public void clearDataFiscalInfoTvaNumber(){clearText(By.id(fiscalInfoTvaFieldId));}
    public void selectFiscalInfoPreviousButton (){click(By.id(fiscalInfoPreviousButtonId));}
    public void selectFiscalInfoNextButton(){click(By.id(fiscalInfoNextButtonId));}

    public void selectFiscalInfoWarningOkButton(){click(By.id(fiscalInfoWarningOkButtonId));}
    public void selectFiscalInfoWarningCancelButton(){click(By.id(fiscalInfoWarningCancelButtonId));}
    public void selectFiscalizationMachineConfirmationOk (){click(By.id(fiscalizationMachineConfirmationOkButtonId));}

    // define elements and methods for VAT programming section
    public String vatProgrammingSectionName = "VAT programming";
    public String vatProgrammingSaveButtonId = "do_program_vat";

    public String vatProgramminFreeLabelId = "vat_free_label";
    public String vatProgrammingFreeValueFieldId = "rep_iva_0";
    public String vatProgrammingFreeDesFieldId = "iva_0_descriptor";

    public String vatProgrammingVAT1LabelId = "vat_1_label";
    public String vatProgrammingVAT1ValueFieldId = "rep_iva_1";
    public String vatProgrammingVAT1DesFieldId = "iva_1_descriptor";

    public String vatProgrammingVAT2LabelId = "vat_2_label";
    public String vatProgrammingVAT2ValueFieldId = "rep_iva_2";
    public String vatProgrammingVAT2DesFieldId = "iva_2_descriptor";

}
