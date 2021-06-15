package fr.hb.benjamin.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hb.benjamin.picom.business.TimeSlot;

public interface TimeSlotDao extends JpaRepository<TimeSlot, Long> {

}
