package com.codermages.shopapp.service;

import java.util.List;

import com.codermages.shopapp.model.Basket;
import com.codermages.shopapp.model.CurrencyType;
import com.codermages.shopapp.model.Offer;
import com.codermages.shopapp.model.ProductType;

public class CostCalculator {
    public double calculateTotalCost(Basket basket, List<Offer> offers, CurrencyType currency) {
        // Implement the logic to calculate total cost based on the items in the basket
        // and the specified currency. For simplicity, we will ignore currency conversion
        // in this implementation.
        double totalCost = 0.0;

        if (basket == null || basket.getItems() == null || basket.getItems().isEmpty()) {
            return totalCost;
        }

        for (ProductType item : basket.getItems()) {
            totalCost += item.getPrice();
        }

        if (offers != null) {
            for (Offer offer : offers) {
                switch (offer) {
                    case BUY_ONE_GET_ONE_FREE_APPLE:
                        int appleCount = basket.getItemCount(ProductType.APPLE);

                        if (appleCount > 1) {
                            totalCost -= (int)(appleCount / 2) * ProductType.APPLE.getPrice();
                        }
                        break;
                    case THREE_FOR_TWO_ORANGE:
                        int orangeCount = basket.getItemCount(ProductType.ORANGE);

                        if (orangeCount > 2) {
                            totalCost -= (int)(orangeCount / 3) * ProductType.ORANGE.getPrice();
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        return totalCost;
    }
}
