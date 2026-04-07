package com.codermages.shopapp.service;

import java.util.List;

import com.codermages.shopapp.model.Basket;
import com.codermages.shopapp.model.ProductType;


public class BasketBuilder {
    public BasketBuilder() {}
    
    public Basket build(List<String> items) throws IllegalArgumentException {
        Basket basket = new Basket();

        for (String item : items) {
            if (item != null) {
                ProductType productTypes = ProductType.valueOf(item.toUpperCase());
                basket.addItem(productTypes);
            }

        }
        return basket;
    }
}


