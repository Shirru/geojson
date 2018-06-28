package ru.annav.geojson.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.annav.geojson.models.Coordinate;

import java.io.IOException;

public class CoordinateDeserializer extends JsonDeserializer<Coordinate> {

    public CoordinateDeserializer() {
        super();
    }

    public Coordinate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonToken token = jsonParser.currentToken();

        if(!JsonToken.START_ARRAY.equals(token)) {
            throw new JsonParseException(jsonParser, "Start of array expected", jsonParser.getCurrentLocation());
        }

        double longitude = readNextDouble(jsonParser);
        double latitude = readNextDouble(jsonParser);

        token = jsonParser.nextToken();
        if(!JsonToken.END_ARRAY.equals(token)) {
            throw new JsonParseException(jsonParser, "End of array expected", jsonParser.getCurrentLocation());
        }

        return new Coordinate(latitude, longitude);
    }

    private double readNextDouble(JsonParser jsonParser) throws IOException {
        JsonToken token = jsonParser.nextToken();
        if (!JsonToken.VALUE_NUMBER_FLOAT.equals(token))
            throw new JsonParseException(jsonParser, "Float value expected", jsonParser.getCurrentLocation());
        return jsonParser.getDoubleValue();
    }
}
