package com.codermages.shopapp.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<ProductType> products;

    public Basket() {
        products = new ArrayList<>();
    }

    public void addItem(ProductType productType) {
        products.add(productType);
    }

    public List<ProductType> getItems() {
        return products;
    }

    public int getItemCount(ProductType productType) {
        int count = 0;
        for (ProductType product : products) {
            if (product == productType) {
                count++;
            }
        }
        return count;
    }
}
