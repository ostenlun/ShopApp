package com.codermages.shopapp;

import java.util.List;

import com.codermages.shopapp.model.Basket;
import com.codermages.shopapp.model.CurrencyType;
import com.codermages.shopapp.service.BasketBuilder;
import com.codermages.shopapp.service.CostCalculator;

public class ShopApp {

    public double calculateCostExample() {
        CostCalculator costCalculator = new CostCalculator();
        BasketBuilder basketBuilder = new BasketBuilder();
        List<String> items = List.of("Apple", "Apple", "Orange", "Apple");
        double totalCost = 0.0;

        try {
            Basket basket = basketBuilder.build(items);
            totalCost = costCalculator.calculateTotalCost(basket, CurrencyType.GBP);

            System.out.printf("Total cost: £%.2f%n", totalCost);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return totalCost;
    }

    public static void main(String[] args) {
        ShopApp shopApp = new ShopApp();
        shopApp.calculateCostExample();
    }
}
