package fr.hb.benjamin.picom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.geojson.Feature;
import org.geojson.GeoJsonObject;
import org.geojson.LngLatAlt;
import org.geojson.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

import fr.hb.benjamin.picom.business.Localisation;
import fr.hb.benjamin.picom.business.Stop;
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

	
    // In this class, I have to use two differents classes of Polygon (vivid and geojson)	
	private List<com.vividsolutions.jts.geom.Polygon> polygons = new ArrayList<>();

	@Override
	public void run(String... args) throws Exception {

		ObjectMapper om = new ObjectMapper();
		GeometryFactory gf = new GeometryFactory();

		if (areaService.getAreas().isEmpty()) {

			Map<String, Object> areaMap = om.readValue(res2.getFile(), new TypeReference<Map<String, Object>>() {
			});

			List<Feature> featuresAreas = om.convertValue(areaMap.get("features"), new TypeReference<List<Feature>>() {
			});

			for (Feature f : featuresAreas) {

				// Extract properties
				Map<String, Object> properties = f.getProperties();

				// Extract geometry
				GeoJsonObject geometry = f.getGeometry();

				Coordinate[] coordinates = new Coordinate[((Polygon) geometry).getExteriorRing().size()];

				int i = 0;
				for (LngLatAlt point : ((Polygon) geometry).getExteriorRing()) {
					coordinates[i++] = new Coordinate(point.getLongitude(), point.getLatitude());
				}
				
				com.vividsolutions.jts.geom.Polygon poly = gf.createPolygon(coordinates);
				polygons.add(poly);

				areaService.addArea(properties.get("nom").toString());
			}
		}

		if (stopService.getStops().isEmpty()) {

			// A JSON can be parsed into a JsonNode object and used to retrieve data from a
			// specific node.
			JsonNode jsonNode = objectMapper.readTree(res.getFile());

			// A Iterator to iterate through the elements of the list "features" in
			// the JSON file.
			Iterator<JsonNode> featuresStops = jsonNode.get("features").elements();

			while (featuresStops.hasNext()) {

				JsonNode lineOfFeatures = featuresStops.next();

				String name = lineOfFeatures.findValue("nom").asText();
				Double longitude = lineOfFeatures.findValue("coordinates").get(0).asDouble();
				Double latitude = lineOfFeatures.findValue("coordinates").get(1).asDouble();

				Localisation localisation = new Localisation();
				localisation.setLatitude(latitude);
				localisation.setLongitude(longitude);

				// Generate a random ipAdress:
				Random r = new Random();
				String ipAdress = r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);

				Stop stop = new Stop();
				stop.setIpAdress(ipAdress);
				stop.setName(name);
				stop.setLocalisation(localisation);

				// This code is not very good, the areas in the bdd has to be in the same order that the polygons in the list of Polygon.. 
				int i = 0;
				for (com.vividsolutions.jts.geom.Polygon poly : polygons) {

					if (poly.contains(gf.createPoint(new Coordinate(longitude, latitude)))) {
						stop.setArea(areaService.getAreas().get(i));
						localisationService.saveLocalisation(localisation);
						stopService.saveStop(stop);
						
					}
					i += 1;
				}
			}
		}
	}
}
