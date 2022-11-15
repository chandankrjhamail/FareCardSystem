package org.farecardsystem.util;

import org.farecardsystem.config.TravelConfig;
import org.farecardsystem.entity.Travel;
import org.farecardsystem.entity.TravelRegulation;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TravelFare {

    private TravelConfig travelConfig;

    public TravelConfig getTravelConfig() {
        return travelConfig;
    }

    public void setTravelConfig(TravelConfig travelConfig) {
        this.travelConfig = travelConfig;
    }

    public BigDecimal findTravelFare(Travel travel) {

        Set<TravelRegulation> travelRegulations = travelConfig.getTravelRegulations();
        Set<TravelRegulation> allMatchedTravelRegulations = new HashSet<>();
        for(TravelRegulation travelRegulation : travelRegulations) {
            if(travelRegulation.matchModeAndTravelPointZones(travel)){
                allMatchedTravelRegulations.add(travelRegulation);
            }
        }

        BigDecimal travelFare = new BigDecimal(3.2);
        for(TravelRegulation travelRegulation : allMatchedTravelRegulations) {
            travelFare = travelRegulation.getTravelFare().min(travelFare);
        }


        return travelFare;
    }
}
