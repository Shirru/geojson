package ru.annav.geojson.models;

import java.util.List;

public class MultiPoint extends Geometry<List<Coordinate>> {

    private List<Coordinate> coordinates;

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}
