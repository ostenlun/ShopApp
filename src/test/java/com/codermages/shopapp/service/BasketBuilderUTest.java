package com.codermages.shopapp.service;import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.codermages.shopapp.model.Basket;
import com.codermages.shopapp.model.ProductType;

public class BasketBuilderUTest {
    BasketBuilder basketBuilder = new BasketBuilder();

    @Test
    public void testBuildBasketWithValidItems() {
        // Given
        List<String> items = Arrays.asList("Apple", "Orange", "Apple");

        // When
        Basket basket = basketBuilder.build(items);

        // Then
        assertEquals(2, basket.getItemCount(ProductType.APPLE));
        assertEquals(1, basket.getItemCount(ProductType.ORANGE));
    }
}
