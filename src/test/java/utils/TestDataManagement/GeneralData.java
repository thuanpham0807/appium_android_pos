package utils.TestDataManagement;

public class GeneralData {
    // Common data
    public static final String VAT_PLACEHOLDER = "  --  ";
    public static final String VAT_DEFAULT_VALUE_01 = "VAT free";
    public static final String VAT_DEFAULT_VALUE_02 = "10.00%";;
    public static final String VAT_DEFAULT_VALUE_03 = "22.00%";
    public static final String DEFAULT_PRINTER_01 = "printer 1";
    public static final String DEFAULT_PRINTER_02 = "printer 2";
    public static final String DEFAULT_PRINTER_03 = "printer 3";
    public static final String DEFAULT_PRINTER_BILLS = "bills";//name(text)
    public static final String DEFAULT_PRINTER_SUMMARY = "summary";//name(text)
    public static final String DEFAULT_PRINTER_DOCS = "docs";//name(text)
    public static final String DEFAULT_DEPT_01 = "DEPT.1";
    public static final String DEFAULT_DEPT_02 = "DEPT.2";
    public static final String DEFAULT_DEPT_03 = "DEPT.3";
    public static final String DEFAULT_DEPT_04 = "DEPT.4";
    public static final String DEFAULT_DEPT_05 = "DEPT.5";
    public static final String PRINTER_IP = "10.0.4.200";// get the ip address from printer and update here whenever you want to run it
    public static final String PRICE_LIST_1 = "price list 1";
    public static final String PRICE_LIST_2 = "price list 2";
    public static final String PRICE_LIST_3 = "price list 3";
    public static final String PRICE_LIST_4 = "price list 4";

    //Specific data only for department
    public static final String TEST_DEPT_NAME = "test category";
    public static final String TEST_DEPT_SECOND_NAME = "test category 2nd name";

    //Specific data only for product
    public static final String TEST_PRODUCT_NAME = "test product";
    public static final String TEST_PRODUCT_2ND_NAME = "test product 2nd name";
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    private static final String NUMERIC_STRING = "0123456789";

    public static String randomNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    private static final String ALPHA_NUMERIC_SYMBOL_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm0123456789`!@#$%^&*()_+=-~[]<>/.,|";
    public static String randomAlphaNumericSymbol(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_SYMBOL_STRING.length());
            builder.append(ALPHA_NUMERIC_SYMBOL_STRING.charAt(character));
        }
        return builder.toString();
    }
}
