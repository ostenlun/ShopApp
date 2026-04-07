package com.codermages.shopapp.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codermages.shopapp.model.Basket;
import com.codermages.shopapp.model.CurrencyType;
import com.codermages.shopapp.model.Offer;

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
        OfferService offerService = new OfferService();

        List<Offer> offers = List.of();

        double totalCost = costCalculator.calculateTotalCost(basket, offers, CurrencyType.GBP);

        // Then
        assertEquals(1.45, 0.001,totalCost);
    }

    @Test
    public void testCostWithOfferBuyOneAppleGetOneFreeWithThreeApples() {
        // Given
        BasketBuilder basketBuilder = new BasketBuilder();
        Basket basket = basketBuilder.build(List.of("Apple", "Orange", "Apple", "Apple"));
        OfferService offerService = new OfferService();

        List<Offer> offers = offerService.getCurrentOffers();
        double totalCost = costCalculator.calculateTotalCost(basket, offers, CurrencyType.GBP);

        // Then
        assertEquals(1.45, 0.001, totalCost);
    }

    @Test
    public void testCostWithOfferBuyOneAppleGetOneFreeWithFourApples() {
        // Given
        BasketBuilder basketBuilder = new BasketBuilder();
        Basket basket = basketBuilder.build(List.of("Apple", "Orange", "Apple", "Apple", "Apple"));
        OfferService offerService = new OfferService();

        List<Offer> offers = offerService.getCurrentOffers();
        double totalCost = costCalculator.calculateTotalCost(basket, offers, CurrencyType.GBP);

        // Then
        assertEquals(1.10, 0.001, totalCost);
    }

    @Test
    public void testCostWithOfferBuyThreeOrangesGetOneFreeWithThreeOranges() {
        // Given
        BasketBuilder basketBuilder = new BasketBuilder();
        Basket basket = basketBuilder.build(List.of("Apple", "Orange", "Orange", "Orange"));
        OfferService offerService = new OfferService();

        List<Offer> offers = offerService.getCurrentOffers();
        double totalCost = costCalculator.calculateTotalCost(basket, offers, CurrencyType.GBP);

        // Then
        assertEquals(1.1, 0.001, totalCost);
    }

    @Test
    public void testCostWithOfferBuyThreeOrangesGetOneFreeWithFourOranges() {
        // Given
        BasketBuilder basketBuilder = new BasketBuilder();
        Basket basket = basketBuilder.build(List.of("Apple", "Orange", "Orange", "Orange", "Orange"));
        OfferService offerService = new OfferService();

        List<Offer> offers = offerService.getCurrentOffers();
        double totalCost = costCalculator.calculateTotalCost(basket, offers, CurrencyType.GBP);

        // Then
        assertEquals(1.35, 0.001, totalCost);
    }
}
