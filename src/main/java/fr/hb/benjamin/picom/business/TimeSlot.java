package fr.hb.benjamin.picom.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name="TimeSlot.findAll", query="SELECT t FROM TimeSlot t")
public class TimeSlot implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private Long idTimeSlot;

	@NotNull(message="Please provide an hour")
	@Getter @Setter
	private int beginingTime;

	
	
	// ------------------------------- Builder ----------------------------------
	public TimeSlot() {
	}


	
	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "TimeSlot [idTimeSlot=" + idTimeSlot + ", beginingTime=" + beginingTime + "]";
	}

}