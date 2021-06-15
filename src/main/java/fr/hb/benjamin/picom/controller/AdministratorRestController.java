package fr.hb.benjamin.picom.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.hb.benjamin.picom.business.Area;
import fr.hb.benjamin.picom.business.Stop;
import fr.hb.benjamin.picom.business.TimeSlot;
import fr.hb.benjamin.picom.service.AreaService;
import fr.hb.benjamin.picom.service.LocalisationService;
import fr.hb.benjamin.picom.service.StopService;
import fr.hb.benjamin.picom.service.TimeSlotService;

@RestController
public class AdministratorRestController {

	// ----------------------------- Attributes ---------------------------------
	private AreaService areaService;
	private StopService stopService;
	private LocalisationService localisationService;
	private TimeSlotService timeSlotService;
	
	
	
	// ------------------------------- Builder ----------------------------------
	public AdministratorRestController(AreaService areaService, StopService stopService, LocalisationService localisationService, TimeSlotService timeSlotService) {
		super();
		this.areaService = areaService;
		this.stopService = stopService;
		this.localisationService = localisationService;
		this.timeSlotService = timeSlotService;
	}
	
	
	
	// ---------------------------- DoGet - DoPost ------------------------------
	
	// **********************Areas************************
	@PostMapping("/areas/{name}")
	public Area addArea(@PathVariable String name) {
		return areaService.addArea(name);
	}
	
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
	
	@PutMapping("/timeSlots/{idTimeSlot}/{isActive}")
	public TimeSlot modifyTimeSlot(@PathVariable Long idTimeSlot, @PathVariable boolean isActive) {
		return timeSlotService.modifyTimeSlot(idTimeSlot, isActive);
	}
}
