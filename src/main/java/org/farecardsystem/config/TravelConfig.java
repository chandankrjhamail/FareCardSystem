package org.farecardsystem.config;

import org.farecardsystem.entity.TravelRegulation;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TravelConfig {
    private BigDecimal maxAllowedFareForTravel;

    private Set<TravelRegulation> travelRegulations = new HashSet<>();

    public BigDecimal getMaxAllowedFareForTravel() {
        return maxAllowedFareForTravel;
    }

    public void setMaxAllowedFareForTravel(BigDecimal maxAllowedFareForTravel) {
        this.maxAllowedFareForTravel = maxAllowedFareForTravel;
    }

    public void setMaxAllowedFareForTravel(int maxAllowedFareForTravel) {
        BigDecimal fareInBigDecimal = new BigDecimal(maxAllowedFareForTravel);
        this.maxAllowedFareForTravel = fareInBigDecimal;
    }

    public void setMaxAllowedFareForTravel(double maxAllowedFareForTravel) {
        BigDecimal fareInBigDecimal = new BigDecimal(maxAllowedFareForTravel);
        this.maxAllowedFareForTravel = fareInBigDecimal;
    }

    public Set<TravelRegulation> getTravelRegulations() {
        return travelRegulations;
    }

    public void setTravelRegulations(Set<TravelRegulation> travelRegulations) {
        this.travelRegulations = travelRegulations;
    }

    public void addTravelRegulation(TravelRegulation travelRegulation){
        travelRegulations.add(travelRegulation);
    }
}
