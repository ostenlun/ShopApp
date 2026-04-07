package com.codermages.shopapp.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codermages.shopapp.model.Basket;
import com.codermages.shopapp.model.CurrencyType;

public class CostCalculatorUTest {
    CostCalculator costCalculator;
    
    @BeforeEach
    public void setUp() {
        costCalculator = new CostCalculator();
    }

    @Test
    public void testCalculateCostWithValidItems() {
        // Given
        BasketBuilder basketBuilder = new BasketBuilder();
        Basket basket = basketBuilder.build(List.of("Apple", "Orange", "Apple"));

        // When
        double totalCost = costCalculator.calculateTotalCost(basket, CurrencyType.GBP);

        // Then
        assertEquals(1.45, totalCost);
    }
}
