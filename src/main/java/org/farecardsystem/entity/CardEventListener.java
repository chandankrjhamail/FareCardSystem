package org.farecardsystem.entity;

import org.farecardsystem.util.TravelFare;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CardEventListener implements PropertyChangeListener {

    private TravelFare travelFare;

    public CardEventListener(TravelFare travelFare) {
        this.travelFare = travelFare;
    }

    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        boolean isTravelling = (boolean) propertyChangeEvent.getNewValue();
        Card card = (Card) propertyChangeEvent.getSource();
        if(isTravelling) {
            card.substractAmountFromCardBalance(travelFare.getTravelConfig().getMaxAllowedFareForTravel());

        } else {
            card.addAmountToCardBalance(travelFare.getTravelConfig().getMaxAllowedFareForTravel());
            card.substractAmountFromCardBalance(travelFare.findTravelFare(card.getTravel()));
        }
    }
}
