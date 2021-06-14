package fr.hb.benjamin.picom.service;

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

}
