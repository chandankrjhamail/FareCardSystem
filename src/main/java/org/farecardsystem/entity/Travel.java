package org.farecardsystem.entity;

public class Travel {

    private ModeOfTransportation modeOfTransportation;
    private Station startingPointStation;
    private Station endingPointStation;

    public ModeOfTransportation getModeOfTransportation() {
        return modeOfTransportation;
    }

    public void setModeOfTransportation(ModeOfTransportation modeOfTransportation) {
        this.modeOfTransportation = modeOfTransportation;
    }

    public Station getStartingPointStation() {
        return startingPointStation;
    }

    public void setStartingPointStation(Station startingPointStation) {
        this.startingPointStation = startingPointStation;
    }

    public Station getEndingPointStation() {
        return endingPointStation;
    }

    public void setEndingPointStation(Station endingPointStation) {
        this.endingPointStation = endingPointStation;
    }

    public static class TravelBuilder {
        private ModeOfTransportation modeOfTransportation;
        private Station startingPointStation;
        private Station endingPointStation;

        public TravelBuilder() {
        }

        public TravelBuilder modeOfTransportation(ModeOfTransportation modeOfTransportation) {
            this.modeOfTransportation = modeOfTransportation;
            return this;
        }

        public TravelBuilder startingPointStation(Station startingPointStation) {
            this.startingPointStation = startingPointStation;
            return this;
        }

        public TravelBuilder endingPointStation(Station endingPointStation) {
            this.endingPointStation = endingPointStation;
            return this;
        }



        public Travel build() {
            Travel travel = new Travel();
            travel.modeOfTransportation = modeOfTransportation;
            travel.startingPointStation = startingPointStation;
            travel.endingPointStation = endingPointStation;
            return travel;
        }

    }

}
