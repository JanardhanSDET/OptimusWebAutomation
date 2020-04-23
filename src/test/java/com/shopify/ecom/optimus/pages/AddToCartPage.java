package com.shopify.ecom.optimus.pages;

import com.shopify.ecom.optimus.utilities.ItemColour;
import com.shopify.ecom.optimus.utilities.ItemSize;
import com.shopify.ecom.optimus.utilities.UserDefinedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.domstorage.model.Item;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPage extends BasePage{


    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="button.btn.product-form__cart-submit.btn--secondary-accent")
    private WebElement addtoCartButton;

    @FindBy(xpath="//button[contains(text(),'Buy it now')]")
    private WebElement buyItNow;

    @FindBy (id="SingleOptionSelector-0")
    private WebElement colorList;

    @FindBy (id="SingleOptionSelector-1")
    private WebElement sizeList;
    @FindBy (css ="a.cart-popup__cta-link.btn.btn--secondary-accent")
    private WebElement viewCartButton;
    @FindBy (css="button.cart-popup__dismiss-button.text-link.text-link--accent")
    private WebElement continueShopping;
    public void addItemToCart(ItemColour color, ItemSize size) throws UserDefinedException {
        waitForVisibilityOfElement(colorList);

        Select selectColor = new Select(colorList);
        selectColor.selectByVisibleText(color.toString());

        Select sizeDropDwon = new Select(sizeList);
        sizeDropDwon.selectByVisibleText(size.toString());

        if(addtoCartButton.getText().equalsIgnoreCase("Add to cart")){
            click(addtoCartButton);

        }else if(addtoCartButton.getText().equalsIgnoreCase("Unavailable")){
            throw new UserDefinedException("Selected Size-"+size.toString()+" is Unavailable");
        }

       click(viewCartButton);

    }

    public void addMultipleSize(ItemColour color, ItemSize size, ItemSize sizeTwo) throws UserDefinedException {
        waitForVisibilityOfElement(colorList);

        Select selectColor = new Select(colorList);
        selectColor.selectByVisibleText(color.toString());

        Select sizeDropDwon = new Select(sizeList);
        sizeDropDwon.selectByVisibleText(size.toString());

        if(addtoCartButton.getText().equalsIgnoreCase("Add to cart")){
            click(addtoCartButton);

        }else if(addtoCartButton.getText().equalsIgnoreCase("Unavailable")){
            throw new UserDefinedException("Selected Size-"+size.toString()+" is Unavailable");
        }

         click(continueShopping);

         addItemToCart(color,sizeTwo );


    }
}
