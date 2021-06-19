package fr.hb.benjamin.picom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.benjamin.picom.business.Bill;
import fr.hb.benjamin.picom.business.User;

public interface BillDao extends JpaRepository<Bill, Long> {

	/**
	 * 
	 * @param idUser: the id of the user
	 * @return: the list of the bills linked to the userid passed in parameter. Return false if the user doesn't existe or if the id is null
	 */
	List<Bill> findAllByUser(User user);
	
}
