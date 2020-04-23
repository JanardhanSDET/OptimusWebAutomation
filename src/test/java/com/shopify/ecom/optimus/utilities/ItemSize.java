package com.shopify.ecom.optimus.utilities;

public enum ItemSize {
    XS("XS"),S("S"),M("M"),L("L"),XL("XL"),TwoXL("2XL"),ThreeXL("3XL"),FourXL("4XL");

    private String value;

    ItemSize(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
