package com.shopify.ecom.optimus.tests;

import com.shopify.ecom.optimus.utilities.ItemColour;
import com.shopify.ecom.optimus.utilities.ItemSize;
import com.shopify.ecom.optimus.utilities.UserDefinedException;
import org.testng.annotations.Test;

public class SearchProductAndAddToCartTest extends  BaseTest{

    @Test
    public  void addProductToCart() throws UserDefinedException {

           homePage.searchForItem(itemName);

           addToCartPage.addItemToCart(ItemColour.Silver, ItemSize.M);

           cartPage.verifyCart(ItemColour.Silver, ItemSize.M,itemName);


    }
}
