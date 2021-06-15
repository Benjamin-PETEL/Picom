package fr.hb.benjamin.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.benjamin.picom.business.Area;
import fr.hb.benjamin.picom.business.Pricing;
import fr.hb.benjamin.picom.business.TimeSlot;
import fr.hb.benjamin.picom.dao.PricingDao;
import fr.hb.benjamin.picom.service.AreaService;
import fr.hb.benjamin.picom.service.PricingService;
import fr.hb.benjamin.picom.service.TimeSlotService;

@Service
public class PricingServiceImpl implements PricingService {

	// ----------------------------- Attributes ---------------------------------
	private PricingDao pricingDao;
	private AreaService areaService;
	private TimeSlotService timeSlotService;
	
	
	
	// ------------------------------- Builder ----------------------------------
	public PricingServiceImpl(PricingDao pricingDao, AreaService areaService, TimeSlotService timeSlotService) {
		super();
		this.pricingDao = pricingDao;
		this.areaService = areaService;
		this.timeSlotService = timeSlotService;
	}

	
	
	// --------------------------- Implementations ------------------------------
	@Override
	public List<Pricing> getAllPricing() {
		return pricingDao.findAll();
	}

	@Override
	public Pricing getPricingByIds(Long idArea, Long idTimeSlot) {
		Area area = areaService.getAreaById(idArea);
		TimeSlot timeSlot = timeSlotService.getTimeSlotById(idTimeSlot);
		if (area!=null && timeSlot!=null) {
			return pricingDao.findByAreaAndTimeSlot(area, timeSlot);
		}
		else {
			return null;
		}
	}

	@Override
	public Pricing savePricing(Long idArea, Long idTimeSlot, float price) {
		if (getPricingByIds(idArea, idTimeSlot)!=null) {
			Pricing pricing = getPricingByIds(idArea, idTimeSlot);
			pricing.setPrice(price);
			return pricingDao.save(pricing);			
		}
		else {
			return null;
		}
	}

}
