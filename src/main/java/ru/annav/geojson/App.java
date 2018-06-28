package ru.annav.geojson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.BasicConfigurator;
import ru.annav.geojson.utils.GeoJsonUtils;

public class App {

    public static void main(String[] args) throws JsonProcessingException {
        BasicConfigurator.configure();
        ObjectMapper objectMapper = new ObjectMapper();

        String initialString = "{\"type\": \"Point\", \"type\": \"Point\", \"coordinates\": [55.689697265625,63.15931607141054]}";
        System.out.println(objectMapper.writeValueAsString(GeoJsonUtils.parseGeoJson(initialString, objectMapper)));

        //        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
//
//        try {
//            FeatureCollection coordinate = objectMapper.readValue(targetStream, FeatureCollection.class);
//            System.out.println(objectMapper.writeValueAsString(coordinate));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
