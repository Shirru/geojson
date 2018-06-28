package ru.annav.geojson.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.annav.geojson.exceptions.GeoJsonParsingException;
import ru.annav.geojson.models.Feature;
import ru.annav.geojson.models.FeatureCollection;
import ru.annav.geojson.models.Geometry;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Collections;

public final class GeoJsonUtils {

    private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static FeatureCollection parseGeoJson(String geoJson, ObjectMapper objectMapper) {
        logger.debug("Starting parsing of geoJson");
        FeatureCollection featureCollection = new FeatureCollection();
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(geoJson);
            String type = jsonNode.get("type").asText();

            if (type == null || type.isEmpty())
                throw new GeoJsonParsingException("Cannot parse geoJson: 'type' field is not presented");

            switch (type) {
                case "FeatureCollection": {
                    logger.debug("Trying to parse to FeatureCollection");
                    featureCollection = objectMapper.treeToValue(jsonNode, FeatureCollection.class);
                    logger.debug("Successfully parsed to FeatureCollection");
                    break;
                }
                case "Feature": {
                    logger.debug("Trying to parse to Feature");
                    Feature feature = objectMapper.treeToValue(jsonNode, Feature.class);
                    logger.debug("Successfully parsed to Feature");
                    featureCollection.setFeatures(Collections.singletonList(feature));
                    break;
                }
                default: {
                    logger.debug("Trying to parse to Geometry");
                    Geometry geometry = objectMapper.treeToValue(jsonNode, Geometry.class);
                    logger.debug("Successfully parsed to {}", geometry.getClass().getSimpleName());
                    Feature feature = new Feature();
                    feature.setGeometry(geometry);
                    featureCollection.setFeatures(Collections.singletonList(feature));
                }
            }
        } catch (IOException e) {
            throw new GeoJsonParsingException("Cannot parse geoJson", e);
        }
        return featureCollection;
    }
}
