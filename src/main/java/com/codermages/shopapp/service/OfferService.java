package com.codermages.shopapp.service;

import java.util.ArrayList;
import java.util.List;

import com.codermages.shopapp.model.Offer;

public class OfferService {
    public OfferService() {}

    public List<Offer> getCurrentOffers() {
        List<Offer> currentOffers = new ArrayList<>();

        currentOffers.add(Offer.BUY_ONE_GET_ONE_FREE_APPLE);
        currentOffers.add(Offer.THREE_FOR_TWO_ORANGE);
        
        return currentOffers;
    }
}
