package ru.annav.geojson.exceptions;

public class GeoJsonParsingException extends RuntimeException {

    public GeoJsonParsingException(String message) {
        super(message);
    }

    public GeoJsonParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
