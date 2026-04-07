package com.codermages.shopapp.model;

public enum ProductType {
    APPLE("Apple", 0.60),
    ORANGE("Orange", 0.25);

    private final String name;
    private final double price;

    ProductType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
