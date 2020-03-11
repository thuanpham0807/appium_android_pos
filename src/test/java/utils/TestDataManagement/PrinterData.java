package utils.TestDataManagement;

public class PrinterData {
    ////PRINTERS ARE FROM IMPORT EXCEL DATA FILE db_20180814_054722_40603200.xls
    public static final String PRINTER_BAR = "Bar";
    public static final String PRINTER_KITCHEN = "Kitchen";
    public static final String PRINTER_FOOD = "Food";
    public static final String PRINTER_DOC = "documents";
    public static final String PRINTER_SUM = "Summary";
    public static final String PRINTER_BILL = "bills";

    private String name;


    public String getName(){return this.name;}
    public void setName(String value){this.name = value;}

}
