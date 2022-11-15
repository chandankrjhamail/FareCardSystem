package org.farecardsystem.entity;

import java.util.List;

public class TravelPoint {

    private Zone startingPointTravelZone;
    private Zone endingPointTravelZone;

    public Zone getStartingPointTravelZone() {
        return startingPointTravelZone;
    }

    public void setStartingPointTravelZone(Zone startingPointTravelZone) {
        this.startingPointTravelZone = startingPointTravelZone;
    }

    public Zone getEndingPointTravelZone() {
        return endingPointTravelZone;
    }

    public void setEndingPointTravelZone(Zone endingPointTravelZone) {
        this.endingPointTravelZone = endingPointTravelZone;
    }

    public boolean matchTravelZones(Travel travel) {
        List<Zone> startingPointZones = travel.getStartingPointStation().getZones();
        List<Zone> endingPointZones = travel.getEndingPointStation().getZones();
        if(startingPointZones.contains(startingPointTravelZone) && endingPointZones.contains(endingPointTravelZone))
            return true;
        else
            return false;
    }
}
