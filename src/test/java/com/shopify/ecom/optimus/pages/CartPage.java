package com.shopify.ecom.optimus.pages;

import com.shopify.ecom.optimus.utilities.ItemColour;
import com.shopify.ecom.optimus.utilities.ItemSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.cart__product-title")
    private WebElement itemName;
    @FindBy(css = "li.product-details__item.product-details__item--variant-option:nth-child(1)")
    private WebElement itemColor;
    @FindBy(css = "li.product-details__item.product-details__item--variant-option:nth-child(2)")
    private WebElement itemSize;
    @FindBy(css = ".cart__qty [name='updates[]']")
    private WebElement quantityBox;
    @FindBy(css = "span.cart-subtotal__price")
    private WebElement subTotal;
    @FindBy(xpath = "//dd[contains(text(),'Rs.')]")
    private WebElement oneQuantityPrice;
    @FindBy(css = "tbody tr.cart__row")
    private WebElement numberOfQuantity;

    public void verifyCart(ItemColour color, ItemSize size, String name) {

        waitForVisibilityOfElement(itemName);
        Assert.assertEquals(itemName.getText(), name);

        String split[] = itemColor.getText().split(":");
        //  Assert.assertEquals(split[1].toString().trim(),color);

        String[] siz = itemSize.getText().split(":");
        //  Assert.assertEquals(siz[1].toString().trim(),size);

    }

    public CartPage increaseProductQuantity(int extraQuantity) throws InterruptedException {
        String actualqty = numberOfQuantity.getAttribute("data-cart-item-quantity");
        int a = Integer.parseInt(actualqty);
        a = a + extraQuantity;
        String newQty = String.valueOf(a);
        quantityBox.clear();
        writeText(quantityBox, newQty);
        click(oneQuantityPrice);
        // driver.navigate().refresh();
        Thread.sleep(2000);
        return this;
    }

    public void verifyPrice() {
        String actualqty = numberOfQuantity.getAttribute("data-cart-item-quantity");
        int quantity = Integer.parseInt(actualqty);

        String qty = oneQuantityPrice.getText();
        String[] split = qty.split("s.");
        double amountForOneQuantity = Double.parseDouble(split[1].trim().replaceAll(",", "").toString());

        double expectedSubTotal = (quantity * amountForOneQuantity);
        String ExpectedSubTotal = "Rs. " + expectedSubTotal;

        String ActualSubTotal = subTotal.getText().replaceAll(",", "");

        Assert.assertEquals(ActualSubTotal, ExpectedSubTotal);


    }
}
