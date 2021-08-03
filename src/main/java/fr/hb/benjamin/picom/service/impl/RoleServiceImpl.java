package fr.hb.benjamin.picom.service.impl;

import org.springframework.stereotype.Service;

import fr.hb.benjamin.picom.business.Role;
import fr.hb.benjamin.picom.dao.RoleDao;
import fr.hb.benjamin.picom.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	
	public RoleServiceImpl(RoleDao roleDao) {
		super();
		this.roleDao = roleDao;
	}
	
	@Override
	public Role save(Role role) {
		return roleDao.save(role);
	}

	@Override
	public Role findById(Long id) {
		return roleDao.findById(id).get();
	}

}
