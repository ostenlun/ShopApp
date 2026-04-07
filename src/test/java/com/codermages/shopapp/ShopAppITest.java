package com.codermages.shopapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ShopAppITest {

    @Test
    public void testShopAppExample() {
        ShopApp shopApp = new ShopApp();
        double totalCost = shopApp.calculateCostExample();
        assertEquals(totalCost, 2.05, 0.001, "Total cost should be £2.05");
    }
}
