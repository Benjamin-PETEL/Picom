package fr.hb.benjamin.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.benjamin.picom.business.Pricing;

public interface PricingDao extends JpaRepository<Pricing, Long> {

	/**
	 * 
	 * @param idArea: the id of the area
	 * @param idTimeSlot: the id of the timeSlot
	 * @return the Pricing if both idArea and idTimeSlot are present in the DB, null otherwise
	 */
	Pricing findByIdAreaAndIdTimeSlot(Long idArea, Long idTimeSlot);
	
}
