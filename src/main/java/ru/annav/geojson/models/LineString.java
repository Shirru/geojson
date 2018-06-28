package ru.annav.geojson.models;

import java.util.List;

public class LineString extends Geometry<List<Coordinate>> {

    private List<Coordinate> coordinates;

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}
