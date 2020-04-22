package com.shopify.ecom.optimus.tests;

import org.testng.annotations.Test;

public class SearchAndProductToCartTest extends  BaseTest{

    @Test
    public  void test1(){

           homePage.searchForItem("Round Neck Shirt 16");


    }
}
