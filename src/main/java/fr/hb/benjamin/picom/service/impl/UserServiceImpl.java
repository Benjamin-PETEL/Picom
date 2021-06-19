package fr.hb.benjamin.picom.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import fr.hb.benjamin.picom.business.User;
import fr.hb.benjamin.picom.dao.UserDao;
import fr.hb.benjamin.picom.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	// ----------------------------- Attributes ---------------------------------
	private UserDao userDao;

	
	
	// ------------------------------- Builder ----------------------------------
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	
	// --------------------------- Implementations ------------------------------
	@Override
	public User findByEmailAndPassword(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
	}

	@Override
	public @Valid User save(@Valid User user) {
		return userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(Long idUser) {
		if (idUser!=null) {
			return userDao.findById(idUser).get();
		}
		else {
			return null;
		}
	}
	
	
}
