package com.shopify.ecom.optimus.tests;

import com.shopify.ecom.optimus.utilities.ItemColour;
import com.shopify.ecom.optimus.utilities.ItemSize;
import com.shopify.ecom.optimus.utilities.UserDefinedException;
import org.testng.annotations.Test;

public class IncreaseProductQuantityInCartTest extends BaseTest {
    @Test
    public  void  increaseProductQuantityInCart() throws InterruptedException, UserDefinedException {

        homePage.searchForItem("Round Neck Shirt 16");

        addToCartPage.addItemToCart(ItemColour.Silver, ItemSize.M);

        cartPage.increaseProductQuantity(2).verifyPrice();


    }
}
