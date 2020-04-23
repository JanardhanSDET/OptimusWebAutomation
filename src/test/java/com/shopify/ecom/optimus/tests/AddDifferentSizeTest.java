package com.shopify.ecom.optimus.tests;

import com.shopify.ecom.optimus.utilities.ItemColour;
import com.shopify.ecom.optimus.utilities.ItemSize;
import com.shopify.ecom.optimus.utilities.UserDefinedException;
import org.testng.annotations.Test;

public class AddDifferentSizeTest extends BaseTest {

    @Test
    public void addDifferentSizeToCart() throws UserDefinedException {
        homePage.verifyHomePage().searchForItem("Round Neck Shirt 15");

        addToCartPage.addMultipleSize(ItemColour.White, ItemSize.S,ItemSize.M);
    }
}
