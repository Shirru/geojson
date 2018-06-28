package ru.annav.geojson.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ru.annav.geojson.models.Coordinate;

import java.io.IOException;

public class CoordinateSerializer extends JsonSerializer<Coordinate> {

    public void serialize(Coordinate coordinate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        double[] array = new double[]{coordinate.getLon(), coordinate.getLat()};
        jsonGenerator.writeArray(array, 0, array.length);
    }
}
