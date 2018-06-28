package ru.annav.geojson.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.annav.geojson.utils.CoordinateDeserializer;
import ru.annav.geojson.utils.CoordinateSerializer;

@JsonDeserialize(using = CoordinateDeserializer.class)
@JsonSerialize(using = CoordinateSerializer.class)
public class Coordinate {

    private double lat;

    private double lon;

    public Coordinate(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
