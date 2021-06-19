package fr.hb.benjamin.picom.service;

import java.util.List;

import fr.hb.benjamin.picom.business.Bill;

public interface BillService {

	/**
	 * 
	 * @param idUser: the id of the user liked to the bill
	 * @return: the bill
	 */
	Bill addBill(Long idUser);

	/**
	 * 
	 * @param idUser: the id of the user
	 * @return: the list of the bills linked to the userid passed in parameter. Return false if the user doesn't existe or if the id is null
	 */
	List<Bill> getBillsByUserId(Long idUser);
	
}
