package fr.hb.benjamin.picom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.hb.benjamin.picom.business.Area;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AreaServiceImplTest {

	// ----------------------------- Attributes ---------------------------------
	@Autowired
	private AreaService areaService;
	private static Area areaIn;
	private static Area areaOut;
	

	
	// -------------------------------- Tests -----------------------------------
	@Test
	@Order(1)
	void testAddArea() {
		String name = "MyArea";
		areaIn = areaService.addArea(name);
		
		// Tests
		assertNotNull(areaIn);
		assertNotNull(areaIn.getIdArea());
		assertEquals(areaIn.getName(), name);
	}
	
	@Test
	@Order(2)
	void testGetAreaById() {
		// Test with a wrong id
		areaOut = areaService.getAreaById(1000l);
		assertNull(areaOut);
		
		// Test with null id
		areaOut = areaService.getAreaById(null);
		assertNull(areaOut);
		
		// Test with a good id
		areaOut = areaService.getAreaById(areaIn.getIdArea());
		assertNotNull(areaOut);
		assertEquals(areaOut, areaIn);
		
	}
	
	@Test
	@Order(3)
	void testGetAreas() {
		List<Area> areas = areaService.getAreas();
		assertNotNull(areas);
		assertTrue(areas.contains(areaIn));
	}

	@Test
	@Order(4)
	void testRenameArea() {
		String name = "MyNewArea";
		areaOut = areaService.renameArea(areaIn.getIdArea(), name);
		assertEquals(areaIn.getIdArea(), areaOut.getIdArea());
		assertEquals(areaOut.getName(), name);
	}

	@Test
	@Order(5)
	void testDeleteArea() {
		boolean out = areaService.deleteArea(areaIn.getIdArea());
		assertFalse(out);
		assertFalse(areaService.getAreas().contains(areaIn));
	}


}
