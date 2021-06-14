package fr.hb.benjamin.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.benjamin.picom.business.Stop;
import fr.hb.benjamin.picom.dao.StopDao;
import fr.hb.benjamin.picom.service.StopService;

@Service
public class StopServiceImpl implements StopService {

	// ----------------------------- Attributes ---------------------------------
	private StopDao stopDao;

	
	
	// ------------------------------- Builder ----------------------------------
	public StopServiceImpl(StopDao stopDao) {
		super();
		this.stopDao = stopDao;
	}



	// --------------------------- Implementations ------------------------------
	@Override
	public List<Stop> getStops() {
		return stopDao.findAll();
	}

	@Override
	public Stop getStopById(Long id) {
		if (id==null || !stopDao.findById(id).isPresent()) {
			return null;
		}
		else{
			return stopDao.findById(id).get();
		}
	}

	@Override
	public Stop saveStop(Stop stop) {
		if (stop.getArea()!=null && stop.getLocalisation()!=null && stop.getName()!=null) {
			return stopDao.save(stop);
			
		}
		else {
			return null;
		}
	}

	@Override
	public boolean deleteStop(Long id) {
		if (id==null || !stopDao.findById(id).isPresent()) {
			return false;			
		}
		else {
			stopDao.deleteById(id);
			return true;
		}
	}

}
