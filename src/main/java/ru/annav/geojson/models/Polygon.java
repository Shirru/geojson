package ru.annav.geojson.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("Polygon")
public class Polygon extends Geometry<List<List<Coordinate>>> {

    private List<List<Coordinate>> coordinates;

    public List<List<Coordinate>> getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(List<List<Coordinate>> coordinates) {
        this.coordinates = coordinates;
    }
}
