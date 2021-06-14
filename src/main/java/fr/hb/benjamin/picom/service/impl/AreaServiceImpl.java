package fr.hb.benjamin.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.benjamin.picom.business.Area;
import fr.hb.benjamin.picom.dao.AreaDao;
import fr.hb.benjamin.picom.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	// ----------------------------- Attributes ---------------------------------
	private AreaDao areaDao;
	
	
	
	// ------------------------------- Builder ----------------------------------
	public AreaServiceImpl(AreaDao areaDao) {
		super();
		this.areaDao = areaDao;
	}

	
	
	// --------------------------- Implementations ------------------------------
	@Override
	public List<Area> getAreas() {
		return areaDao.findAll();
	}

	@Override
	public Area getAreaById(Long id) {
		if (id==null) {
			return null;
		}
		if (areaDao.findById(id).isPresent()) {
			return areaDao.findById(id).get();
		}
		else {
			return null;
		}
	}
	
	@Override
	public Area addArea(String name) {
		Area area = new Area();
		area.setName(name);
		return areaDao.save(area);
	}

	@Override
	public boolean deleteArea(Long id) {
		Area area = areaDao.findById(id).get();
		if(area != null) {
			if (area.getStops().size()==0) {
				areaDao.deleteById(id);
				return true;
			}
			else {
				System.out.println("this area contains some stops");
				return false;
			}
		}
		else {
			return false;			
		}
	}

	@Override
	public Area renameArea(Long id, String name) {
		Area area = areaDao.findById(id).get();
		if(area != null) {
			area.setName(name);
			return areaDao.save(area);
		}
		else {
			return null;			
		}
	}

}
