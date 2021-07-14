package fr.hb.benjamin.picom;

import java.util.List;
import java.util.Map;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeoJsonObject;
import org.geojson.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.hb.benjamin.picom.business.Area;
import fr.hb.benjamin.picom.service.AreaService;
import fr.hb.benjamin.picom.service.LocalisationService;
import fr.hb.benjamin.picom.service.StopService;

//https://stackoverflow.com/questions/59416836/map-geojson-to-java-with-jackson

// CommandLineRunner is a simple spring boot interface with a run method. The run method
// will be called automatically by the spring boot system after the initial boot.
@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private AreaService areaService;

	@Autowired
	private StopService stopService;

	@Autowired
	private LocalisationService localisationService;

	// https://www.baeldung.com/jackson-object-mapper-tutorial
	@Autowired
	private ObjectMapper objectMapper;

	@Value("classpath:json/tcl_sytral.json")
	private Resource res;

	@Value("classpath:json/arrondissements.json")
	private Resource res2;

	@Override
	public void run(String... args) throws Exception {

		ObjectMapper om = new ObjectMapper();

		Map<String, Object> resultMap = om.readValue(res2.getFile(), new TypeReference<Map<String, Object>>() {
		});
		List<Feature> features = om.convertValue(resultMap.get("features"), new TypeReference<List<Feature>>() {
		});

		for (Feature f : features) {

			// Extract properties
			Map<String, Object> properties = f.getProperties();

			// Extract geometry
			GeoJsonObject geometry = f.getGeometry();

			if (geometry instanceof Polygon) {

				Area area = new Area();
				Polygon contour = (Polygon) geometry;
				areaService.addArea(properties.get("nom").toString(), contour);

			} else {
				throw new RuntimeException("Unhandled geometry type: " + geometry.getClass().getName());
			}
		}
	}
}


//        Point point2 = objectMapper.readValue(res2.getFile(), Point.class);
//		
//
//		
//		
//		while (features.hasNext()) {
//			 
//			JsonNode lineOfFeatures = features.next();
//
//			String name = lineOfFeatures.findValue("nom").asText();
//			List<JsonNode> contour = lineOfFeatures.findValues("coordinates");
//		
//			Object[] coordinates = lineOfFeatures.findValues("coordinates").toArray();
//			
//		}
//		
//		if (stopService.getStops().isEmpty()) {
//			
//			// For the moment, we add one area to the database which will contains all stops.
//			Area defaultArea = areaService.addArea(new String("area1"));
//			
//			// A JSON can be parsed into a JsonNode object and used to retrieve data from a
//			// specific node.
//			JsonNode jsonNode = objectMapper.readTree(res.getFile());
//
//			// A Iterator to iterate through the elements of the list "features" in
//			// the JSON file.
//			Iterator<JsonNode> features = jsonNode.get("features").elements();
//
//			while (features.hasNext()) {
//  
//				JsonNode lineOfFeatures = features.next();
//  
//				String name = lineOfFeatures.findValue("nom").asText();
//				String longitude = lineOfFeatures.findValue("coordinates").get(0).asText();
//				String latitude = lineOfFeatures.findValue("coordinates").get(1).asText();
//
//				Localisation localisation = new Localisation(); 
//				localisation.setLatitude(latitude);
//				localisation.setLongitude(longitude);
//				localisationService.saveLocalisation(localisation);
//
//				// Generate a random ipAdress:
//				Random r = new Random();
//				String ipAdress = r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
//
//				Stop stop = new Stop(); 
//				stop.setIpAdress(ipAdress);
//				stop.setName(name);
//				stop.setLocalisation(localisation);
//				stop.setArea(defaultArea);
//
//				stopService.saveStop(stop);
//			
//
//			}
//		}
//	}
