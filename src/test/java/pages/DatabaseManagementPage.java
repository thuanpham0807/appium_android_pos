package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class DatabaseManagementPage extends BasePage {

    public DatabaseManagementPage(AndroidDriver<AndroidElement> driver){
        super (driver);
    }
    // define element locators
    public String databaseManagementTabName = "databases management";//name(text)
    public String dataManagementSectionId = "db_management";
    public String BackupButtonId = "archive_backup_button";//id
    public String folderPath1OptionId = "archive_backup_config";//id
    public String folderPath2OptionId = "archive_backup_2_config";//id
    public String backupRestoreButtonId = "archive_restore_button";//id
    public String importButtonId = "archive_import_button";//id
    public String exportButtonId = "archive_export_button";//id
    public String statisticsResetButtonId = "archive_reset_stats_button";//id
    public String openedBillsResetButtonId = "archive_reset_conti_button";//id
    public String countersResetButtonId = "archive_reset_counters_button";//id
    public String grandTotalResetButtonId = "archive_reset_grand_total_button";//id
    public String emptyDrawerButtonId = "cashdrawer_reset";//id
    public String statisticsRebuildButtonId = "archive_rebuild_stats_button";//id
    public String operatorsAttenndanceResetButtonId = "operator_reset";//id
    public String refurbishButtonId = "bt_refurbish";
    public String okButtonId = "button1";
    public String cancelButtonId = "button2";

    // define methods for database management section
    public void selectDatabasesManagementTab(){click(By.name(databaseManagementTabName));}
    public void selectImportDataButton (){click(By.id(importButtonId));}
    public void selectRefurbishButton(){click(By.id(refurbishButtonId));}
    public void selectRefurbishConfirmationOkButton(){click(By.id(okButtonId));}

    // define methods for Purge and Archive section
}
