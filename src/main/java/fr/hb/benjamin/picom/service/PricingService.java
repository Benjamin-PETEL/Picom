package fr.hb.benjamin.picom.service;

import java.util.List;

import fr.hb.benjamin.picom.business.Pricing;

public interface PricingService {

	/**
	 * 
	 * @return the list of all the pricing
	 */
	List<Pricing> getAllPricing();
	
	/**
	 * 
	 * @param idArea: the id of the area
	 * @param idTimeSlot: the id of the timeSlot
	 * @return the Pricing if both idArea and idTimeSlot are present in the DB, null otherwise
	 */
	Pricing getPricingByIds(Long idArea, Long idTimeSlot);
	
	/**
	 * 
	 * @param idArea: the id of the area
	 * @param idTimeSlot: the id of the timeSlot
	 * @param price: the new price (must be >0 )
	 * @return the Pricing if both idArea and idTimeSlot are present in the DB, null otherwise
	 */
	Pricing savePricing(Long idArea, Long idTimeSlot, float price);
	
}
