package fr.hb.benjamin.picom.service;

import java.util.List;

import fr.hb.benjamin.picom.business.TimeSlot;

public interface TimeSlotService {

	/**
	 * 
	 * @return the list of all the time slots
	 */
	List<TimeSlot> getTimeSlots();
	
	/**
	 * 
	 * @param idTimeSlot: the id of the timeSlot to modify
	 * @param isActive: boolean to activate or desactivated the timeSlot
	 * @return: the modified timeSlot, if the id is present in the DB, null otherwise
	 */
	TimeSlot modifyTimeSlot(Long idTimeSlot, boolean isActive);
	
}
