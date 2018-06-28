package ru.annav.geojson.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Collections;
import java.util.Map;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
public class Feature {

    private Map<String, Object> properties = Collections.emptyMap();

    private Geometry geometry;

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }
}
