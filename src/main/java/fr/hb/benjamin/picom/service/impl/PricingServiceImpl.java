package fr.hb.benjamin.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.benjamin.picom.business.Pricing;
import fr.hb.benjamin.picom.dao.PricingDao;
import fr.hb.benjamin.picom.service.PricingService;

@Service
public class PricingServiceImpl implements PricingService {

	// ----------------------------- Attributes ---------------------------------
	private PricingDao pricingDao;
	
	
	
	// ------------------------------- Builder ----------------------------------
	public PricingServiceImpl(PricingDao pricingDao) {
		super();
		this.pricingDao = pricingDao;
	}

	
	
	// --------------------------- Implementations ------------------------------
	@Override
	public List<Pricing> getAllPricing() {
		return pricingDao.findAll();
	}

	@Override
	public Pricing getPricingByIds(Long idArea, Long idTimeSlot) {
		if (idArea!=null && idTimeSlot!=null && pricingDao.findByIdAreaAndIdTimeSlot(idArea, idTimeSlot)!=null) {
			return pricingDao.findByIdAreaAndIdTimeSlot(idArea, idTimeSlot);
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
