package com.shopify.ecom.optimus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OptimusEcomsComingSoonPage extends BasePage {


    public OptimusEcomsComingSoonPage(WebDriver driver) {
        super(driver);
    }

   @FindBy(xpath="//*[@href='#LoginModal']")
   private WebElement passwordButton;

    public OptimusEcomsComingSoonPage verifyHomePage(){
     
        Assert.assertEquals(driver.getTitle(),"ecom.optimus – Opening Soon");
        return this;
    }

    public void navigateStorePasswordPage(){

        click(passwordButton);

        
    }
}
