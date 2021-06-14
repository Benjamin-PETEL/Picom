package fr.hb.benjamin.picom.service;

import java.util.List;

import fr.hb.benjamin.picom.business.Stop;

public interface StopService {
	
	/**
	 * 
	 * @return the list of all the stop
	 */
	List<Stop> getStops();
	
	/**
	 * 
	 * @param id: the id of the stop requested
	 * @return the requested Stop, null if the id is null or if the stop don't exist
	 */
	Stop getStopById(Long id);

	/**
	 * 
	 * @param stop: The stop must at least have a name, an area, a localisation.
	 * @return the stop with its id if all param are ok, null otherwise.
	 */
	Stop saveStop(Stop stop);
	
	/**
	 * 
	 * @param id: the id of the stop to delete. The id must be not null and be present in the DB.
	 * @return true if the stop was deleted, false otherwise.
	 */
	boolean deleteStop(Long id);
	
}
