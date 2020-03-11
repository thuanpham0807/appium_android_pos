package pages;


import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BasePage {


    protected AndroidDriver<AndroidElement> driver;

    public BasePage(AndroidDriver driver) {

        this.driver = driver;
    }

    public void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isElementPresent(By by) {
        System.out.print("element" + by + "\n");
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    /* useless code block but don't touch or clear the inside of codes
    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.50);
        swipeObject.put("startY", 0.95);
        swipeObject.put("endX", 0.50);
        swipeObject.put("endY", 0.01);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }
    public void swipeLeftToRight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.01);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.9);
        swipeObject.put("endY", 0.6);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }
    public void swipeRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeFirstCarouselFromRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.2);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.2);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }
    */
    public void swipeRightToLeft(int timeduration) {
        // duration should be in milliseconds
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.70);
        int endx = (int) (size.width * 0.30);
        int starty = size.height / 2;
        driver.swipe(startx, starty, endx, starty, timeduration);

    }

    public void swipeRightToLeftPointToPoint(int timeduration, int startX, int StartY, int endX, int startY) {
        // duration should be in milliseconds

        driver.swipe(startX, startY, endX, startY, timeduration);

    }

    public void swipeRightToLeftInElementDimensionFindById(int timeduration, String elementId){

        Dimension size = driver.manage().window().getSize();
        int elementWidth = driver.findElement(By.id(elementId)).getSize().getWidth();
        int elementHeight = driver.findElement(By.id(elementId)).getSize().getHeight();
        int elementPointX = driver.findElement(By.id(elementId)).getLocation().getX();
        int elementPointY = driver.findElement(By.id(elementId)).getLocation().getY();
        System.out.print("point Y: "+elementPointY);

        int startx = (int) ((elementPointX + elementWidth)*0.7);// startx = element locationX + width
        System.out.print("startX:"+startx);
        int endx = (int) (elementPointX * 0.1);
        System.out.print("endX: "+ endx);
        int starty = elementHeight / 2;
        System.out.print("startY: "+ starty);
        driver.swipe(startx, starty, endx, starty, timeduration);
    }

    public void swipeLeftToRight(int timeduration) {
        // duration should be in milliseconds
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.70);
        int endx = (int) (size.width * 0.30);
        int starty = size.height / 2;
        driver.swipe(endx, starty, startx, starty, timeduration);
    }

    public void swipeLeftToRightInElementDimensionFindById(int timeduration, String elementId){

        Dimension size = driver.manage().window().getSize();
        int elementWidth = driver.findElement(By.id(elementId)).getSize().getWidth();
        int elementHeight = driver.findElement(By.id(elementId)).getSize().getHeight();
        int elementPointX = driver.findElement(By.id(elementId)).getLocation().getX();
        int elementPointY = driver.findElement(By.id(elementId)).getLocation().getY();

        int startx = (int) ((elementPointX + elementWidth)*0.7);// startx = element locationX + width
        System.out.print("startX:"+startx);
        int endx = (int) (elementPointX * 0.1);
        System.out.print("endX: "+ endx);
        int starty = size.height / 2;
        System.out.print("startY: "+ starty);
        driver.swipe(endx, starty, startx, starty, timeduration);
    }

    public void swipeTopToBottom(int timeduration) {
        // duration should be in milliseconds
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        driver.swipe(startx, endy, startx, starty, timeduration);
    }

    public void swipeBottomToTop(int timeduration) {
        // duration should be in milliseconds
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        driver.swipe(startx, starty, startx, endy, timeduration);
    }

    public void swipeBottomToTopInElementDimensionFindById(int timeduration, String elementId){

        Dimension size = driver.manage().window().getSize();
        int elementWidth = driver.findElement(By.id(elementId)).getSize().getWidth();
        int elementHeight = driver.findElement(By.id(elementId)).getSize().getHeight();
        int elementPointX = driver.findElement(By.id(elementId)).getLocation().getX();
        int elementPointY = driver.findElement(By.id(elementId)).getLocation().getY();
        System.out.print("point Y: "+elementPointY);

        int startx = (int) ((elementPointX + elementWidth)*0.5);// startx = element locationX + width
        System.out.print("startX:"+startx);
        int starty = elementPointY;
        int endy = elementPointY - elementHeight;
        System.out.print("startY: "+ starty);
        driver.swipe(startx, starty, startx, endy, timeduration);
    }

    public void swipeBottomToTopItemToItem(int timeduration, String element1Id, String element2Id){

        Dimension size = driver.manage().window().getSize();
        int element1Width = driver.findElement(By.id(element1Id)).getSize().getWidth();
        int element1Height = driver.findElement(By.id(element1Id)).getSize().getHeight();
        int element1PointX = driver.findElement(By.id(element1Id)).getLocation().getX();
        int element1PointY = driver.findElement(By.id(element1Id)).getLocation().getY();
        int element2Width = driver.findElement(By.id(element2Id)).getSize().getWidth();
        int element2Height = driver.findElement(By.id(element2Id)).getSize().getHeight();
        int element2PointX = driver.findElement(By.id(element2Id)).getLocation().getX();
        int element2PointY = driver.findElement(By.id(element2Id)).getLocation().getY();

        int startx = (int) ((element1PointX + element1Width)*0.5);// startx = element locationX + width
        int starty = element1PointY;
        int endy = element2PointY;
        driver.swipe(startx, starty, startx, endy, timeduration);
    }

    public void performTapAction(WebElement elementToTap) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("x", (double) 360); // in pixels from left
        tapObject.put("y", (double) 170); // in pixels from top
        tapObject.put("element", Double.valueOf(((RemoteWebElement) elementToTap).getId()));
        js.executeScript("mobile: tap", tapObject);
    }

    public void tapOnItem(By elementLocation)
    {
        TouchAction action = new TouchAction(driver);
        int x = driver.findElement(elementLocation).getLocation().getX() + 50;
        int y = driver.findElement(elementLocation).getLocation().getY() + 14;
        action.tap(x, y).waitAction(500);
        action.perform();
    }

    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    public void longPress(By by){new TouchAction(driver).longPress(driver.findElement(by)).waitAction(2000).perform();}

    public void clickOnAnItemInHomeProductArea(String itemName){
        String xpath = "//android.widget.TextView[contains(@resource-id,'pos_grid_item_product_text') and @text='"+itemName+"']";
        driver.findElementByXPath(xpath).click();
    }
    public void longPressOnAnItemInHomeProductArea(String itemName){
        String xpath = "//android.widget.TextView[contains(@resource-id,'pos_grid_item_product_text') and @text='"+itemName+"']";
        new TouchAction(driver).longPress(driver.findElement(By.xpath(itemName))).perform();
    }

    public void clickOnAnItemInHomeOperatorDisplayArea(String itemName){
        String xpath = "//android.widget.TextView[contains(@resource-id,'item_name') and @text='"+itemName+"']";
        System.out.print("this is xpath"+xpath);
        driver.findElementByXPath(xpath).click();
    }
    public void longPressOnAnItemInHomeOperatorDisplayArea(String itemName){
        String xpath = "//android.widget.TextView[contains(@resource-id,'item_name') and @text='"+itemName+"']";
        new TouchAction(driver).longPress(driver.findElement(By.xpath(itemName))).perform();
    }

    public String readText(By elementLocation) {
        System.out.print(driver.findElement(elementLocation).getText() +"\n");
        return driver.findElement(elementLocation).getText();
    }

    public void writeText(By elementLocation, String text) {
        System.out.print(driver.findElement(elementLocation).getText() + text);
        driver.findElement(elementLocation).sendKeys(text);
    }

    public void clearText(By elementLocation) {
        driver.findElement(elementLocation).clear();
    }


    public void longPressOnItemByName(String itemName){
        new TouchAction(driver).longPress(driver.findElement(By.name(itemName))).perform();
    }

    public void tapOnDeviceBackKey() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    public boolean isSelected(By elementLocation) {
        return driver.findElement(elementLocation).isSelected();
    }

    public boolean isChecked(By elementLocation) {
        String flag = driver.findElement(elementLocation).getAttribute("checked");
        if (flag.equalsIgnoreCase("true")) {
            return true;
        }
        else
            return false;
    }

    public boolean isSwitched(By elementLocation) {
        String flag = driver.findElement(elementLocation).getText();
        System.out.print("get text of switch "+ flag);
        if (flag.equalsIgnoreCase("YES")) {
            return true;
        }
        else
            return false;
    }

    public boolean isPresent(By elementLocation) {
        return driver.findElement(elementLocation).isDisplayed();
    }

    public void tapOnDeviceHomeKey() {
        driver.pressKeyCode(AndroidKeyCode.HOME);
    }

    public void resumeApp() {
        driver.runAppInBackground(3);
        driver.startActivity("com.embedia.pos", "com.embedia.pos/com.embedia.pos.admin.Administration", null, null);
    }

    public void scrollToText(String textValue) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(" + "\"" + textValue + "\"" +"))"));
    }

    public void scrollToElementID (String elementId){
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches("+"\""+".*id/"+elementId+"\""+")"));
    }

    public void scrollToElementIDInScrollViewID(String scrollViewId, String elementId){
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(" +"\"" + ".*id/"+ scrollViewId + "\""+")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(" + "\"" + ".*id/" + elementId + "\"" + ")";
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
    }
    public void tapOnPoint(Integer x, Integer y) {
        new TouchAction(driver).tap(x, y).waitAction(300).perform();
    }
    public void tapOnPointInTimes(Integer x, Integer y, Integer times){
        for(int i = 0; i<times;i++){
            new TouchAction(driver).tap(x,y).perform();
        }
    }
    public void clickOnElementByLocation(String elementId){
        int locationX = driver.findElement(By.id(elementId)).getLocation().getX();
        int locationY = driver.findElement(By.id(elementId)).getLocation().getY();
        int height = driver.findElement(By.id(elementId)).getSize().getHeight();
        int width = driver.findElement(By.id(elementId)).getSize().getWidth();
        int pointX = locationX + width/2;
        int pointY = locationY + height/2;
        new TouchAction(driver).tap(pointX, pointY).perform();
    }

    public void selectADepartmentByName(String deptName) {
        click(By.name(deptName));
    }
    public void selectAProductByName(String prodName) {
        click(By.name(prodName));
    }
    public void selectACustomerByName(String prodName) {
        click(By.name(prodName));
    }
    public void selectOkInConfirmation(){click(By.id("button1"));}
    public void selectCancelInConfirmation(){click(By.id("button2"));}
    public void restartDevice(){
        // -- Linux --

        // Run a shell command
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "adb reboot");

        // Run a shell script
        //processBuilder.command("path/to/hello.sh");

        // -- Windows --

        // Run a command
        //processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\mkyong");

        // Run a bat file
        //processBuilder.command("C:\\Users\\mkyong\\hello.bat");

        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void relaunchApp(){
        driver.runAppInBackground(5);
        driver.startActivity("com.embedia.pos", "com.embedia.pos.Main");
    }
}
