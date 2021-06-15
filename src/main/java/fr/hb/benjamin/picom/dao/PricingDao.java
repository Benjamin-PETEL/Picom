package fr.hb.benjamin.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.benjamin.picom.business.Pricing;

public interface PricingDao extends JpaRepository<Pricing, Long> {

}
