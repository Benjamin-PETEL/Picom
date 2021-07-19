//package fr.hb.benjamin.picom.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import fr.hb.benjamin.picom.business.Area;
//import fr.hb.benjamin.picom.business.Localisation;
//import fr.hb.benjamin.picom.business.Stop;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class StopServiceImplTest {
//
//	// ----------------------------- Attributes ---------------------------------
//		@Autowired
//		private StopService stopService;
//		@Autowired
//		private AreaService areaService;
//		@Autowired
//		private LocalisationService localisationService;
//		private static Stop stopIn;
//		private static Stop stopOut;
//		private static Long stopId;
//		private static Localisation localisation;
//		private static Area area;
//		private static String name;
//		
//		
//	// -------------------------------- Tests -----------------------------------
//	@Test
//	@Order(1)
//	void testSaveStop() {
////		area = areaService.addArea("MyArea");
//		
//		localisation = new Localisation();
////		localisation.setLatitude("123");
////		localisation.setLongitude("456");
//		localisation = localisationService.saveLocalisation(localisation);
//		
//		name = "MyStop";
//		
//		stopIn = new Stop();
//		stopIn.setName(name);
//		stopIn.setArea(area);
//		stopIn.setLocalisation(localisation);
//		
//		// check if all parameters are ok, id is null
//		stopOut = stopService.saveStop(stopIn);
//		assertNotNull(stopOut);
//		assertNotNull(stopOut.getIdStop());
//		assertEquals(stopOut.getName(), name);
//		assertEquals(stopOut.getArea(), stopIn.getArea());
//		assertEquals(stopOut.getLocalisation(), stopIn.getLocalisation());
//		assertEquals(stopOut.getName(), stopIn.getName());
//		
//		// TODO check how to avoid having twice the same name
//		// check if the same name is present in the DB
//		//stopOut = stopService.saveStop(stopIn);
//		//assertNull(stopOut);
//		
//		// check modification of parameter
//		name = "MyNewStopName";
//		stopId = stopOut.getIdStop();
//		stopOut.setName(name);
//		stopOut = stopService.saveStop(stopOut);
//		assertEquals(stopOut.getName(), name);
//		assertEquals(stopOut.getIdStop(), stopId);
//		
//		// check if name is null
//		stopIn.setName(null);
//		stopOut = stopService.saveStop(stopIn);
//		assertNull(stopOut);
//		stopIn.setName(name);
//		
//		// check if localisation is null
//		stopIn.setLocalisation(null);
//		stopOut = stopService.saveStop(stopIn);
//		assertNull(stopOut);
//		stopIn.setLocalisation(localisation);
//		
//		// check if area is null
//		stopIn.setArea(null);
//		stopOut = stopService.saveStop(stopIn);
//		assertNull(stopOut);
//		stopIn.setArea(area);
//		
//	}
//	
//	@Test
//	@Order(2)
//	void testGetStopById() {
//		// check if id is null
//		stopOut = stopService.getStopById(null);
//		assertNull(stopOut);
//		
//		// check if the id is not in the DB
//		stopOut = stopService.getStopById(100l);
//		assertNull(stopOut);
//		
//		// check with a good id
//		stopOut = stopService.getStopById(stopId);
//		assertNotNull(stopOut);
//		assertEquals(stopOut.getIdStop(), stopId);
//		assertEquals(stopOut.getName(), name);
//		assertEquals(stopOut.getArea(), area);
//		assertEquals(stopOut.getLocalisation(), localisation);
//		
//	}
//
//	@Test
//	@Order(3)
//	void testGetStops() {
//		List<Stop> stops = stopService.getStops();
//		assertNotNull(stops);
//		assertTrue(stops.contains(stopOut));
//	}
//
//	@Test
//	@Order(4)
//	void testDeleteStop() {
//		assertTrue(stopService.deleteStop(stopId));
//		assertFalse(stopService.deleteStop(stopId));
//		assertFalse(stopService.deleteStop(null));
//	}
//
//}
