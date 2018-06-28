package ru.annav.geojson.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Point")
public class Point extends Geometry<Coordinate> {

    private Coordinate coordinates;

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }
}
