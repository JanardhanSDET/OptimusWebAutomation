package com.shopify.ecom.optimus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy ( xpath="//button[@class='btn--link site-header__icon site-header__search-toggle js-drawer-open-top']")
    private WebElement searchButton;
    @FindBy (css ="[name='q'][placeholder='Search']")
    private WebElement searchTextBox;
    @FindBy (css="button.search-bar__submit.search-form__submit")
    private WebElement searchIcon;
    // //*[@href='/products/shirt-16?_pos=1&_psq=Round%20Neck%20Shirt%2016&_ss=e&_v=1.0']
    @FindBy (css="div.predictive-search-wrapper.predictive-search-wrapper--drawer.predictive-search-wrapper--visible")
    private WebElement resultList;
    @FindBy (css = "span.predictive-search-item__title-text")
    private WebElement result;
    @FindBy (css="ul.grid.grid--uniform.grid--view-items>li")
    private List<WebElement> listOfFeaturedCollection;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage verifyHomePage(){
         waitForVisibilityOfElement(searchButton);
        Assert.assertEquals(driver.getTitle(),"ecom.optimus");
        return  this;
    }

    public void searchForItem(String item){
        click(searchButton);
        writeText(searchTextBox,item);
        click(result);

    }

    public void selectFeaturedCollectionProduct(){
          click(listOfFeaturedCollection.get(0));
    }


}
