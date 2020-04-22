package com.shopify.ecom.optimus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageGenerator {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(this.driver, 100);
    Actions actions = new Actions(driver);
    public <T> void click(T elementAttr) {

        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));
            driver.findElement((By) elementAttr).click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));
            ((WebElement) elementAttr).click();
        }
    }

    public <T> void writeText(T elementAttr, String text) {
        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
            driver.findElement((By) elementAttr).sendKeys(text);
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

     public void waitForVisibilityOfElement(WebElement element){
         wait.until(ExpectedConditions.visibilityOf(element));
     }
}
