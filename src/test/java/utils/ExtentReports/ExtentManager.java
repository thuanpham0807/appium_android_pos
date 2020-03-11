package utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            //String workingDir = System.getProperty("D:\\RCH_WorkingFiles\\AtosAutoTestDemo\\");
            extent = new ExtentReports("C:\\Users\\User\\Desktop\\AtosAppiumTest\\Reports\\AtosTestExportReport.html", true);
        }
        return extent;
    }
}
