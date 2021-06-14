package fr.hb.benjamin.picom.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name="Rate.findAll", query="SELECT r FROM Rate r")
public class Rate implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Min(value=0, message="please provide a positive value")
	@Getter @Setter
	private float value;

	@ManyToOne
	@JoinColumn(name="idZone")
	@Getter @Setter
	private Area area;

	@ManyToOne
	@JoinColumn(name="idPlageHoraire")
	@Getter @Setter
	private TimeSlot timeSlot;

	
	
	// ------------------------------- Builder ----------------------------------
	public Rate() {
	}

	
	
	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Rate [value=" + value + ", area=" + area + ", timeSlot=" + timeSlot + "]";
	}
	
}