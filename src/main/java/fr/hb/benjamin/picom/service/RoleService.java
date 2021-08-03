package fr.hb.benjamin.picom.service;

import fr.hb.benjamin.picom.business.Role;

public interface RoleService {

	Role save(Role role);
	
	Role findById(Long id);
	
}
