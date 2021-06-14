package fr.hb.benjamin.picom.service;

import java.util.List;

import fr.hb.benjamin.picom.business.Area;

public interface AreaService {

	/**
	 * 
	 * @return the list of all the area
	 */
	List<Area> getAreas();
	
	/**
	 * 
	 * @param id of the area looked for
	 * @return the area corresponding to the id
	 */
	Area getAreaById(Long id);

	/**
	 * 
	 * @param name: the name of the area to add
	 * @return the added area
	 */
	Area addArea(String name);
	
	/**
	 * 
	 * @param id: the id of the area
	 * @param name: the new name of the area
	 * @return the renamed area
	 */
	Area renameArea(Long id, String name);

	/**
	 * 
	 * @param id: the id of the area. The area to remove must be present in the database and don't have any stops.
	 * @return true if the area was deleted, false otherwise
	 */
	boolean deleteArea(Long id);

}
