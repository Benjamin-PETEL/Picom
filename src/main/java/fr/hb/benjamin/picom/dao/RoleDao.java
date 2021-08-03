package fr.hb.benjamin.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.benjamin.picom.business.Role;

public interface RoleDao extends JpaRepository<Role, Long>{

}
