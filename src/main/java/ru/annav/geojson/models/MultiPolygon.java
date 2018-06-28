package ru.annav.geojson.models;

import java.util.List;

public class MultiPolygon extends Geometry<List<List<List<Coordinate>>>> {

    private List<List<List<Coordinate>>> coordinates;

    public List<List<List<Coordinate>>> getCoordinates() {
        return coordinates;
    }
}
