package fr.hb.benjamin.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.benjamin.picom.business.Advert;

public interface AdvertDao extends JpaRepository<Advert, Long> {

}
