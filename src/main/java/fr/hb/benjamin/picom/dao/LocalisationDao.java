package fr.hb.benjamin.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.benjamin.picom.business.Localisation;

public interface LocalisationDao extends JpaRepository<Localisation, Long> {

}
