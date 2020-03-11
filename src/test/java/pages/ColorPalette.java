package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import utils.TestDataManagement.Color;

public class ColorPalette extends BasePage {

    public ColorPalette(AndroidDriver<AndroidElement> driver){
        super (driver);
    }

    public String colorPickerColorgridId = "color_picker_color_grid";

    // define pick color method

    public void pickWhiteColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10,colorGridLocationY+colorGridHeight/12);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickGreenDeYorkColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*3,colorGridLocationY+colorGridHeight/12);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickRedSalmonColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*5,colorGridLocationY+colorGridHeight/12);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickYellowSweetCornColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*7,colorGridLocationY+colorGridHeight/12);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickVioletLilacBushColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*9,colorGridLocationY+colorGridHeight/12);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickOrangePeelColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10,colorGridLocationY+colorGridHeight/12*3);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickBlueCornflowerColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*3,colorGridLocationY+colorGridHeight/12*3);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickVioletLightOrchidColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*5,colorGridLocationY+colorGridHeight/12*3);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickSandyBrownColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*7,colorGridLocationY+colorGridHeight/12*3);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickTickleMePinkColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*9,colorGridLocationY+colorGridHeight/12*3);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickRedPomegranateColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10,colorGridLocationY+colorGridHeight/12*5);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickRedAmaranthColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*3,colorGridLocationY+colorGridHeight/12*5);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickVioletDarkOrchidColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*5,colorGridLocationY+colorGridHeight/12*5);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickPurpleHeartColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*7,colorGridLocationY+colorGridHeight/12*5);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickFreeSpeechBlueColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*9,colorGridLocationY+colorGridHeight/12*5);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickDodgerBlueColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10,colorGridLocationY+colorGridHeight/12*7);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickDeepSkyBlueColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*3,colorGridLocationY+colorGridHeight/12*7);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickIrisBlueColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*5,colorGridLocationY+colorGridHeight/12*7);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickDarkCyanColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*7,colorGridLocationY+colorGridHeight/12*7);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickForestGreenColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*9,colorGridLocationY+colorGridHeight/12*7);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickGreenMantisColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10,colorGridLocationY+colorGridHeight/12*9);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickLasPalmasGreenColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*3,colorGridLocationY+colorGridHeight/12*9);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickGorseYellowColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*5,colorGridLocationY+colorGridHeight/12*9);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickAmberYellowColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*7,colorGridLocationY+colorGridHeight/12*9);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickWePeepPinkColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*9,colorGridLocationY+colorGridHeight/12*9);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickPersianRedColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10,colorGridLocationY+colorGridHeight/12*11);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickIronstoneBrownColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*3,colorGridLocationY+colorGridHeight/12*11);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickMartiniBrownColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*5,colorGridLocationY+colorGridHeight/12*11);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickNobelGrayColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*7,colorGridLocationY+colorGridHeight/12*11);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
    public void pickHokiBlueColor()
    {
        int colorGridWidth = driver.findElement(By.id(colorPickerColorgridId)).getSize().getWidth();
        int colorGridHeight = driver.findElement(By.id(colorPickerColorgridId)).getSize().getHeight();
        int colorGridLocationX = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getX();
        int colorGridLocationY = driver.findElement(By.id(colorPickerColorgridId)).getLocation().getY();
        Color color = new Color(colorGridLocationX+colorGridWidth/10*9,colorGridLocationY+colorGridHeight/12*11);
        tapOnPoint(color.getLocationX(),color.getLocationY());
    }
}
