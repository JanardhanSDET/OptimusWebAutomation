package com.shopify.ecom.optimus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class StorePasswordPage extends BasePage {

    public StorePasswordPage(WebDriver driver) {
        super(driver);
    }

     @FindBy(id="Password")
    private WebElement passwordField;
    @FindBy (xpath= "//*[@name='commit' and @type='submit']")
    private WebElement enterButton;
    @FindBy(id="password-modal-heading")
    private WebElement heading;


    public StorePasswordPage verifyStorePasswordPage(){
        waitForVisibilityOfElement(heading);
        Assert.assertEquals(heading.getText(),"ENTER STORE USING PASSWORD");
       return  this;
    }

    public void nagivagateToHomePage(String password){
        writeText(passwordField,password);
        actions.moveToElement(enterButton).click().build().perform();
    }

}
