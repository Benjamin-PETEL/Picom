package fr.hb.benjamin.picom.service.impl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.benjamin.picom.business.TimeSlot;
import fr.hb.benjamin.picom.dao.TimeSlotDao;
import fr.hb.benjamin.picom.service.TimeSlotService;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

	// ----------------------------- Attributes ---------------------------------
	private TimeSlotDao timeSlotDao;
	
	
	
	// ------------------------------- Builder ----------------------------------
	public TimeSlotServiceImpl(TimeSlotDao timeSlotDao) {
		super();
		this.timeSlotDao = timeSlotDao;
	}

	
	
	// --------------------------- Implementations ------------------------------
	@Override
	public List<TimeSlot> getTimeSlots() {
		return timeSlotDao.findAll();
	}

	@Override
	public TimeSlot modifyTimeSlot(Long idTimeSlot, boolean isActive) {
		if (idTimeSlot==null || timeSlotDao.findById(idTimeSlot).get()==null) {
			return null;
		}
		else {
			TimeSlot timeSlot = timeSlotDao.findById(idTimeSlot).get();
			timeSlot.setActive(isActive);
			return timeSlotDao.save(timeSlot);
		}
	}



	@Override
	public TimeSlot addTimeSlot(LocalTime localTime) {
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setActive(false);
		timeSlot.setBeginingTime(localTime);
		return timeSlotDao.save(timeSlot);
	}



	@Override
	public TimeSlot getTimeSlotById(Long idTimeSlot) {
		return timeSlotDao.findById(idTimeSlot).get();
	}

}
