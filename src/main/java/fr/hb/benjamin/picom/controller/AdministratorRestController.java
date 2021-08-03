package fr.hb.benjamin.picom.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.hb.benjamin.picom.business.Advert;
import fr.hb.benjamin.picom.business.AdvertPNG;
import fr.hb.benjamin.picom.business.Area;
import fr.hb.benjamin.picom.business.Bill;
import fr.hb.benjamin.picom.business.Pricing;
import fr.hb.benjamin.picom.business.Role;
import fr.hb.benjamin.picom.business.RoleEnum;
import fr.hb.benjamin.picom.business.Stop;
import fr.hb.benjamin.picom.business.TimeSlot;
import fr.hb.benjamin.picom.business.User;
import fr.hb.benjamin.picom.service.AdvertService;
import fr.hb.benjamin.picom.service.AreaService;
import fr.hb.benjamin.picom.service.BillService;
import fr.hb.benjamin.picom.service.LocalisationService;
import fr.hb.benjamin.picom.service.PricingService;
import fr.hb.benjamin.picom.service.RoleService;
import fr.hb.benjamin.picom.service.StopService;
import fr.hb.benjamin.picom.service.TimeSlotService;
import fr.hb.benjamin.picom.service.UserService;


@RestController
//@CrossOrigin(origins = "", allowedHeaders = "")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministratorRestController {

	// ----------------------------- Attributes ---------------------------------
	private AreaService areaService;
	private StopService stopService;
	private LocalisationService localisationService;
	private TimeSlotService timeSlotService;
	private PricingService pricingService;
	private AdvertService advertService;
	private BillService billService;
	private UserService userService;
	private RoleService roleService;
	
	
	// ------------------------------- Builder ----------------------------------
	public AdministratorRestController(AreaService areaService, StopService stopService, LocalisationService localisationService, TimeSlotService timeSlotService, PricingService pricingService, AdvertService advertService, BillService billService, UserService userService, RoleService roleService) {
		super();
		this.areaService = areaService;
		this.stopService = stopService;
		this.localisationService = localisationService;
		this.timeSlotService = timeSlotService;
		this.pricingService = pricingService;
		this.advertService =  advertService;
		this.billService = billService;
		this.userService = userService;
		this.roleService = roleService;
	}
	
	
	
	// --------------------------------- Init -----------------------------------
	@PostConstruct
	private void init() {
		initTimeSlots();
		initRoles();
		initUsers();
	}
	
	private void initTimeSlots() {
		// Initialisation of the timeSlots
		if (timeSlotService.getTimeSlots().isEmpty()) {
			for (int i=0; i<24; i++) {
				timeSlotService.addTimeSlot(LocalTime.of(i, 0));
				if (i>6 && i<=20) {
					timeSlotService.modifyTimeSlot(Long.valueOf(i), true);
				}
			}
		}	
	}
	
	private void initRoles() {
		for (RoleEnum roleEnum : RoleEnum.values()) {
			Role role = new Role();
			role.setIdRole(roleEnum.getId());
			role.setName(roleEnum.getName());
			roleService.save(role);
		}
	}
	
	private void initUsers() {
		System.out.println("initUsers:");
		if (userService.findAll().isEmpty()) {
			User user = new User();
			List<Role> roles = new ArrayList<>();
			Role role = roleService.findById(RoleEnum.ROLE_ADMIN.getId());
			roles.add(role);
			user.setFistName("Benjamin");
			user.setLastName("PETEL");
			user.setEmail("benjamin.petel@mail.com");
			user.setRoles(roles);
			System.out.println(roles);
			System.out.println(user);
			userService.save(user);
			System.out.println("End of initusers");
		}
	}
	
	// ---------------------------- DoGet - DoPost ------------------------------
	
	// **********************Areas************************
//	@PostMapping("/areas/{name}")
//	public Area addArea(@PathVariable String name) {
//		return areaService.addArea(name);
//	}
	
	
//    @PostMapping(value = "/users")
//    ResponseEntity<User> saveCandidat(@Valid @RequestBody User user) {
//        this.userService.ajouterUser(user);
//        return new ResponseEntity<User>(user, HttpStatus.CREATED);
//    }
//	
	
	@GetMapping("/areas")
	public List<Area> getAreas(){
		return areaService.getAreas();
	}
	
	@GetMapping("/areas/{id}")
	public Area getAreaById(@PathVariable Long id) {
		return areaService.getAreaById(id);
	}
	
	@PutMapping("/areas/{id}/{name}")
	public Area renameArea(@PathVariable Long id, @PathVariable String name) {
		return areaService.renameArea(id, name);
	}
	
	@DeleteMapping("/areas/{id}")
	public boolean deleteArea(@PathVariable Long id) {
		return areaService.deleteArea(id);
	}
	
	
	// **********************Stops************************
	@PostMapping("/stops/{name}/{idArea}/{idLocalisation}/{ipAdress}")
	public Stop addStop(@PathVariable String name, @PathVariable Long idArea, @PathVariable Long idLocalisation, @PathVariable String ipAdress) {
		Stop stop = new Stop();
		stop.setName(name);
		stop.setArea(areaService.getAreaById(idArea));
		stop.setLocalisation(localisationService.getLocalisationById(idLocalisation));
		stop.setIpAdress(ipAdress);
		return stopService.saveStop(stop);
	}
	
	@GetMapping("/stops")
	public List<Stop> getStops(){
		return stopService.getStops();
	}
	
	@GetMapping("/stops/{idStop}")
	public Stop getStopById(@PathVariable Long idStop) {
		return stopService.getStopById(idStop);
	}
	
	@PutMapping("/stops/{idStop}/{name}/{idArea}/{idLocalisation}/{ipAdress}")
	public Stop editStop(@PathVariable Long idStop, @PathVariable String name, @PathVariable Long idArea, @PathVariable Long idLocalisation, @PathVariable String ipAdress) {
		Stop stop = stopService.getStopById(idStop);
		stop.setName(name);
		stop.setArea(areaService.getAreaById(idArea));
		stop.setLocalisation(localisationService.getLocalisationById(idLocalisation));
		stop.setIpAdress(ipAdress);
		return stopService.saveStop(stop);
	}
	
	@DeleteMapping("/stops/{idStop}")
	public boolean deleteStop(@PathVariable Long idStop) {
		return stopService.deleteStop(idStop);
	}
	
	
	// *******************TimeSlots***********************
	@GetMapping("/timeSlots")
	public List<TimeSlot> getTimeSlots(){
		return timeSlotService.getTimeSlots();
	}
	
	@PostMapping("/timeSlots/{idTimeSlot}/{isActive}")
	public TimeSlot modifyTimeSlot(@PathVariable Long idTimeSlot, @PathVariable boolean isActive) {
		return timeSlotService.modifyTimeSlot(idTimeSlot, isActive);
	}
	
	
	
	// *********************Pricing***********************
	@GetMapping("/pricings")
	public List<Pricing> getAllPricings(){
		return pricingService.getAllPricing();
	}
	
	@GetMapping("/pricings/{idArea}/{idTimeSlot}")
	public Pricing getPricingByIds(@PathVariable Long idArea, @PathVariable Long idTimeSlot) {
		return pricingService.getPricingByIds(idArea, idTimeSlot);
	}
	
	@PostMapping("/pricings/{idArea}/{idTimeSlot}/{price}")
	public Pricing savePricing(@PathVariable Long idArea, @PathVariable Long idTimeSlot, @PathVariable float price) {
		return pricingService.savePricing(idArea, idTimeSlot, price);
	}
	
	
	
	// **********************Advert***********************
	@GetMapping("/adverts")
	public List<Advert> getAllAdverts(){
		return advertService.findAll();
	}
	
	@PostMapping("/adverts/{startDate}/{endDate}/PNG/{url}")
	public Advert addAdvertPNG(@PathVariable String startDate, @PathVariable String endDate, @PathVariable String url) {
		AdvertPNG advertPNG = new AdvertPNG();
		advertPNG.setStartDate(LocalDate.parse(startDate));
		advertPNG.setEndDate(LocalDate.parse(endDate));
		advertPNG.setUrl(url);
		return advertService.saveAdvert(advertPNG);
	}
	
	@PutMapping("/adverts/{idAdvert}/{newEndDate}")
	public Advert modifyAdvert(@PathVariable Long idAdvert, @PathVariable String newEndDate) {
		if (idAdvert==null || advertService.findById(idAdvert)==null) {
			return null;
		}
		Advert advert = advertService.findById(idAdvert);
		advert.setEndDate(LocalDate.parse(newEndDate));
		return advertService.saveAdvert(advert);
	}
	
	@DeleteMapping("/adverts/{idAdvert}")
	public boolean removeAdvert(@PathVariable Long idAdvert) {
		return advertService.removeAdvert(idAdvert);
	}
	
	
	
	// ***********************Bill************************
	@PostMapping("/bills/{idUser}")
	public Bill addBill(@PathVariable Long idUser) {
		return billService.addBill(idUser);
	}
	
	@GetMapping("/bills/user/{idUser}")
	public List<Bill> getBillsByUserId(@PathVariable Long idUser){
		return billService.getBillsByUserId(idUser);
	}
	
	
	
	// ***********************User************************
	@PostMapping("/users/{firstName}/{lastName}/{email}/{password}/{phone}")
	public User addUser(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String email, @PathVariable String password, @PathVariable String phone) {
		User user = new User();
		user.setFistName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneNumber(phone);
		return userService.save(user);
	}
	
	@PostMapping("/users/{email}/{password}")
	public User getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		return userService.findByEmailAndPassword(email, password);
	}
	
	@PutMapping("/users/{idUser}/{firstName}/{lastName}/{email}/{password}/{phone}")
	public User modifyUserById(@PathVariable Long idUser, @PathVariable String firstName, @PathVariable String lastName, @PathVariable String email, @PathVariable String password, @PathVariable String phone) {
		User user = userService.findById(idUser);
		if (user==null) {
			return null;
		}
		user.setFistName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneNumber(phone);
		return userService.save(user);
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.findAll();
	}
}
