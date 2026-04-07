package com.codermages.shopapp;
// Pre-Interview Exercise:
// For Developer Candidates

// The following exercise will assess your ability to deliver well-structured and maintainable
// code. As a TDD shop we will put equal emphasis on evaluating your tests as we will on the
// code itself. The exercise should only take 20 - 40 minutes; don’t spend much longer than
// this. Please make sure the code is tested and the tests are clearly shown.

// Please complete the following exercise in Java 21. You may be asked to make further
// amendments to your code during a pair programming exercise with a member of the team.
// Please use git to version control your exercise. After completing the first step, please clearly
// tag the commit so that we can evaluate your approach. You may make other commits to
// further demonstrate your approach. Please compress your answers and submit them via
// your agent or send us a link to your Github (or similar) account. Do not send us binaries,
// they won’t get through our firewalls.

// Your answers will be used as part of our sifting and are likely to be discussed with your
// interviewer at later stages.

// • You are building a checkout system for a shop which only sells apples and oranges
// • Apples cost 60p and oranges cost 25p
// • Build a checkout system which takes a list of items scanned at the till and outputs the total cost
// - For example: [ Apple, Apple, Orange, Apple ] => £2.05
// • Make reasonable assumptions about the inputs to your solution; for example, many candidates
// take a list of strings as input
// Step 1: Shopping cart

// • The shop decides to introduce two new offers
// - Buy one, get one free on apples
// - 3 for the price of 2 on oranges
// • Update your checkout functions to include the offers

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
