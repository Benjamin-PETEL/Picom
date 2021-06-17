package fr.hb.benjamin.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.benjamin.picom.business.Advert;
import fr.hb.benjamin.picom.business.AdvertPNG;
import fr.hb.benjamin.picom.business.User;
import fr.hb.benjamin.picom.dao.AdvertDao;
import fr.hb.benjamin.picom.dao.AdvertPNGDao;
import fr.hb.benjamin.picom.service.AdvertService;

@Service
public class AdvertServiceImpl implements AdvertService {

	// ----------------------------- Attributes ---------------------------------
	private AdvertDao advertDao;
	private AdvertPNGDao advertPNGDao;
	
	
	
	// ------------------------------- Builder ----------------------------------
	public AdvertServiceImpl(AdvertDao advertDao, AdvertPNGDao advertPNGDao) {
		super();
		this.advertDao = advertDao;
		this.advertPNGDao = advertPNGDao;
	}

	
	
	// --------------------------- Implementations ------------------------------
	@Override
	public List<Advert> findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advert> findAll() {
		return advertDao.findAll();
	}

	@Override
	public Advert saveAdvert(Advert advert) {
		if (advert.getClass()==AdvertPNG.class) {
			return advertPNGDao.save((AdvertPNG)advert);			
		}
		return null;
	}

	@Override
	public boolean removeAdvert(Long idAdvert) {
		if (idAdvert!=null && advertDao.findById(idAdvert).get()!=null) {
			advertDao.deleteById(idAdvert);
			return true;
		}
		else {
			return false;			
		}
	}

	@Override
	public Advert findById(Long idAdvert) {
		return advertDao.findById(idAdvert).get();
	}
		
}
