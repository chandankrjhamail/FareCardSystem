package org.farecardsystem.entity;

import org.farecardsystem.payment.Payment;
import org.farecardsystem.payment.PaymentStrategy;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;

public class Card {

    private PropertyChangeSupport propertyChangeSupport;
    private BigDecimal balance = new BigDecimal(0);
    private boolean isTravelling = false;
    private Travel travel;

    public Card() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    public double getBalance() {
        return balance.doubleValue();
    }

    public void setBalance(int balance) {
        this.balance = BigDecimal.valueOf(balance);
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public void addAmountToCardBalance(int amount) {
        BigDecimal amountToBeAdded = new BigDecimal(amount);
        this.balance = balance.add(amountToBeAdded);
    }

    public void substractAmountFromCardBalance(int amount){
        BigDecimal amountToBeSubstracted = new BigDecimal(amount);
        this.balance = balance.subtract(amountToBeSubstracted);
    }

    public void addAmountToCardBalance(double amount) {
        BigDecimal amountToBeAdded = new BigDecimal(amount);
        this.balance = balance.add(amountToBeAdded);
    }

    public void substractAmountFromCardBalance(double amount){
        BigDecimal amountToBeSubstracted = new BigDecimal(amount);
        this.balance = balance.subtract(amountToBeSubstracted);
    }

    public void addAmountToCardBalance(BigDecimal amount) {
        this.balance = balance.add(amount);
    }

    public void substractAmountFromCardBalance(BigDecimal amount){
        this.balance = balance.subtract(amount);
    }

    public void loadBalance(double amount, Payment payment) {
        payment.pay(amount);
        addAmountToCardBalance(amount);
    }

    public void checkInCheckOut(ModeOfTransportation modeOfTransportation, Station station) {
        if(!isTravelling) {
            travel = new Travel.TravelBuilder()
                    .modeOfTransportation(modeOfTransportation)
                    .startingPointStation(station)
                    .build();
            propertyChangeSupport.firePropertyChange("isTravelling", isTravelling, true);
            isTravelling = true;
        }
        else {
            travel.setEndingPointStation(station);
            propertyChangeSupport.firePropertyChange("isTravelling", isTravelling, false);
            isTravelling = false;
        }

    }

}
