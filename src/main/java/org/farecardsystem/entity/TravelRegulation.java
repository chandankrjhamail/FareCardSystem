package org.farecardsystem.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TravelRegulation {

    private BigDecimal travelFare;
    private ModeOfTransportation modeOfTransportation;
    private Set<TravelPoint> travelPoints = new HashSet<>();

    public BigDecimal getTravelFare() {
        return travelFare;
    }

    public void setTravelFare(BigDecimal travelFare) {
        this.travelFare = travelFare;
    }

    public void setTravelFare(int travelFare) {
        BigDecimal travelFareInBigDecimal = new BigDecimal(travelFare);
        this.travelFare = travelFareInBigDecimal;
    }

    public void setTravelFare(double travelFare) {
        BigDecimal travelFareInBigDecimal = new BigDecimal(travelFare);
        this.travelFare = travelFareInBigDecimal;
    }

    public ModeOfTransportation getModeOfTransportation() {
        return modeOfTransportation;
    }

    public void setModeOfTransportation(ModeOfTransportation modeOfTransportation) {
        this.modeOfTransportation = modeOfTransportation;
    }

    public Set<TravelPoint> getTravelPoints() {
        return travelPoints;
    }

    public void setTravelPoints(Set<TravelPoint> travelPoints) {
        this.travelPoints = travelPoints;
    }

    public boolean matchModeAndTravelPointZones(Travel travel) {
        for(TravelPoint travelPoint : travelPoints) {
            if(travelPoint.matchTravelZones(travel))
                return true;
        }
        if(modeOfTransportation != null && modeOfTransportation.equals(travel.getModeOfTransportation()) && travelPoints.isEmpty())
            return true;
        else
            return false;
    }

    public synchronized void addTravelPoints(TravelPoint travelPoint) {
        travelPoints.add(travelPoint);
    }

}
