package com.shopify.ecom.optimus.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShortUtility {

    public static void takeScreenShort(WebDriver driver, String name)  {

        TakesScreenshot  ts=(TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source,new File("ScreenShorts/"+name+".png"));
            System.out.println("ScreenShort Taken");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
