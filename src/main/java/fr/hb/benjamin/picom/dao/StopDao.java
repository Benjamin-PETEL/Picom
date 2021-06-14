package fr.hb.benjamin.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.benjamin.picom.business.Stop;

public interface StopDao extends JpaRepository<Stop, Long> {

}
