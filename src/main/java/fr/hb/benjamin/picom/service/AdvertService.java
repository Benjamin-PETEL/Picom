package fr.hb.benjamin.picom.service;

import java.util.List;

import fr.hb.benjamin.picom.business.Advert;
import fr.hb.benjamin.picom.business.User;

public interface AdvertService {

	/**
	 * 
	 * @param user: the user for which we seek the Adverts
	 * @return: null if user is null / empty List if the user doesn't have any advert / the list of advert of the user otherwise
	 */
	List<Advert> findByUser(User user);
	
	/**
	 * 
	 * @return return the list of all the adverts
	 */
	List<Advert> findAll();
	
	/**
	 * 
	 * @param advertPNG: the AdvertPNG to save
	 * @return null if advertPNG is null, the advertPNG with its id otherwise
	 */
	Advert saveAdvert(Advert advert);
	
	/**
	 * 
	 * @param idAdvert: the id of the advert to remove
	 * @return: true if the advert was deleted / false otherwise (the advert doesn't exist or the id=null)
	 */
	boolean removeAdvert(Long idAdvert);

	/**
	 * 
	 * @param idAdvert: the id of the advert to find
	 * @return: the advert with the given id / null if the id is not in the DB or if id is null
	 */
	Advert findById(Long idAdvert);
	
}
