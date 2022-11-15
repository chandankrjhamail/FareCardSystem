package org.farecardsystem.entity;

import java.util.List;

public class Station {
    private String name;
    private List<Zone> zones;

    public Station(String name, List<Zone> zones) {
        this.name = name;
        this.zones = zones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }
}
