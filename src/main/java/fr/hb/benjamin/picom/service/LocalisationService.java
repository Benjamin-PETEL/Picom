package fr.hb.benjamin.picom.service;

import java.util.List;

import fr.hb.benjamin.picom.business.Localisation;

public interface LocalisationService {

	/**
	 * 
	 * @return the list of all the localisations
	 */
	List<Localisation> getLocalisations();
	
	/**
	 * 
	 * @param idLocalisation: the id of the localisation
	 * @return the localisation
	 */
	Localisation getLocalisationById(Long idLocalisation);
	
	/**
	 * 
	 * @param localisation
	 * @return the localisation with its id
	 */
	Localisation saveLocalisation(Localisation localisation);

	/**
	 * 
	 * @param id: the id of the localisation to delete
	 * @return true if the localisation was deleted, false otherwise
	 */
	boolean deleteLocalisation(Long id);
	
}
