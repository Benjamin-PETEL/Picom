package fr.hb.benjamin.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.benjamin.picom.business.Bill;
import fr.hb.benjamin.picom.dao.BillDao;
import fr.hb.benjamin.picom.service.BillService;
import fr.hb.benjamin.picom.service.UserService;

@Service
public class BillServiceImpl implements BillService {

	// ----------------------------- Attributes ---------------------------------
	BillDao billDao;
	UserService userService;
	
	
	
	// ------------------------------- Builder ----------------------------------	
	public BillServiceImpl(BillDao billDao, UserService userService) {
		super();
		this.billDao = billDao;
		this.userService = userService;
	}
	
	
	
	// --------------------------- Implementations ------------------------------
	@Override
	public Bill addBill(Long idUser) {
		Bill bill = new Bill();
		bill.setUser(userService.findById(idUser));
		// The date will be initialised at the payement.
		return billDao.save(bill);
	}



	@Override
	public List<Bill> getBillsByUserId(Long idUser) {
		if (idUser!=null && userService.findById(idUser)!=null) {
			return billDao.findAllByUser(userService.findById(idUser));
		}
		else {
			return null;			
		}
	}



}
