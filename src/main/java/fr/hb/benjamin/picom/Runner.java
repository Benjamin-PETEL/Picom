package fr.hb.benjamin.picom;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.hb.benjamin.picom.business.Area;
import fr.hb.benjamin.picom.business.Localisation;
import fr.hb.benjamin.picom.business.Stop;
import fr.hb.benjamin.picom.service.AreaService;
import fr.hb.benjamin.picom.service.LocalisationService;
import fr.hb.benjamin.picom.service.StopService;

@Component
public class Runner implements CommandLineRunner {
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private StopService stopService;

	@Autowired
	private LocalisationService localisationService;

	@Autowired
	private ObjectMapper objectMapper;

	@Value("classpath:json/tcl_sytral.json")
	private Resource res;

	@Override
	public void run(String... args) throws Exception {

		JsonNode jsonNode = objectMapper.readTree(res.getFile());

		Iterator<JsonNode> features = jsonNode.get("features").elements();

		while (features.hasNext()) {

			JsonNode lineOfFeatures = features.next();

			String name = lineOfFeatures.findValue("nom").toString();
			String longitude = lineOfFeatures.findValue("coordinates").get(0).toString();
			String latitude = lineOfFeatures.findValue("coordinates").get(1).toString();
			
			Localisation localisation = new Localisation(latitude,longitude );
			localisationService.saveLocalisation(localisation);
			
//			Area area = new Area();
//			area.setName("defaultByName");
			
			Area area = areaService.addArea(new String("defaultByName"));
			Stop stop = new Stop(name,localisation,area );

			stopService.saveStop(stop);
			

		}

	}

}
