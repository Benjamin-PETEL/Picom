package fr.hb.benjamin.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.benjamin.picom.business.Localisation;
import fr.hb.benjamin.picom.dao.LocalisationDao;
import fr.hb.benjamin.picom.service.LocalisationService;

@Service
public class LocalisationServiceImpl implements LocalisationService {

	// ----------------------------- Attributes ---------------------------------
	private LocalisationDao localisationDao;
	
	
	
	// ------------------------------- Builder ----------------------------------
	public LocalisationServiceImpl(LocalisationDao localisationDao) {
		super();
		this.localisationDao = localisationDao;
	}
	
	
	
	// --------------------------- Implementations ------------------------------	
	@Override
	public Localisation saveLocalisation(Localisation localisation) {
		if (localisation.getLatitude()==null || localisation.getLongitude()== null) {
			return null;			
		}
		else {
			return localisationDao.save(localisation);
		}
	}

	@Override
	public Localisation getLocalisationById(Long idLocalisation) {	
		return localisationDao.findById(idLocalisation).get();
	}

	@Override
	public List<Localisation> getLocalisations() {
		return localisationDao.findAll();
	}

	@Override
	public boolean deleteLocalisation(Long id) {
		if (id==null || !localisationDao.findById(id).isPresent()) {
			return false;
		}
		else {
			localisationDao.deleteById(id);
			return true;
		}
	}




}
