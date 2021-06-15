package fr.hb.benjamin.picom.service;

import java.time.LocalTime;
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
	
	/**
	 * Add a timeSlot which begins at the time given in parameter. The TimeSlot is initialized isActive=false
	 * @param localTime: the time at which the time slot begins
	 * @return: the added TimeSlot
	 */
	TimeSlot addTimeSlot(LocalTime localTime);

	/**
	 * 
	 * @param idTimeSlot: the id of the timeSlot to get
	 * @return: the timeSlot if it exist, null otherwise
	 */
	TimeSlot getTimeSlotById(Long idTimeSlot);
	
}
