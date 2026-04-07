package com.codermages.shopapp.service;

import com.codermages.shopapp.model.Basket;
import com.codermages.shopapp.model.CurrencyType;
import com.codermages.shopapp.model.ProductType;

public class CostCalculator {
    public double calculateTotalCost(Basket basket, CurrencyType currency) {
        // Implement the logic to calculate total cost based on the items in the basket
        // and the specified currency. For simplicity, we will ignore currency conversion
        // in this implementation.
        double totalCost = 0.0;

        for (ProductType item : basket.getItems()) {
            totalCost += item.getPrice();
        }

        return totalCost;
    }
}
