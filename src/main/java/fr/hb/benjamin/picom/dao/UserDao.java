package fr.hb.benjamin.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.benjamin.picom.business.User;

public interface UserDao extends JpaRepository<User, Long> {

	/**
	 * 
	 * @param email
	 * @param password
	 * @return the user corresponding to the email and password, null otherwise
	 */
	User findByEmailAndPassword(String email, String password);

}
