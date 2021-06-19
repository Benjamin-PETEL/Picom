package fr.hb.benjamin.picom.service;

import java.util.List;

import javax.validation.Valid;

import fr.hb.benjamin.picom.business.User;

public interface UserService {

	/**
	 * 
	 * @param email
	 * @param password
	 * @return the user corresponding to the email and password, null otherwise
	 */
	User findByEmailAndPassword(String email, String password);

	/**
	 * 
	 * @param user
	 * @return user
	 */
	@Valid
	User save(@Valid User user);

	/**
	 * 
	 * @return the list of all the user
	 */
	List<User> findAll();
	
	/**
	 * 
	 * @param idUser: the id of the user you want to get
	 * @return: the user looked for if it exist, null if udUser is null or if the user doesn't exist
	 */
	User findById(Long idUser);
	
}
