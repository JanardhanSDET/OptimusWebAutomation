package com.shopify.ecom.optimus.tests;

import com.shopify.ecom.optimus.utilities.ItemColour;
import com.shopify.ecom.optimus.utilities.ItemSize;
import com.shopify.ecom.optimus.utilities.UserDefinedException;
import org.testng.annotations.Test;

public class FeaturedCollectionProductTest extends BaseTest {

    @Test
    public void addFeaturedCollectionProductToCart() throws UserDefinedException {
        homePage.selectFeaturedCollectionProduct();

        addToCartPage.addItemToCart(ItemColour.White, ItemSize.M);

    }
}
