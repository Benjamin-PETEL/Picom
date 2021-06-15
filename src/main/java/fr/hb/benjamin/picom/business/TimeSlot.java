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
	private Long idTimeSlot;

	private int beginingTime;

	private boolean isActive;

	
	
	// ------------------------------- Builder ----------------------------------
	public TimeSlot() {
	}


	
	// ----------------------------- Set - Get ----------------------------------
	public Long getIdTimeSlot() {
		return idTimeSlot;
	}

	public void setIdTimeSlot(Long idTimeSlot) {
		this.idTimeSlot = idTimeSlot;
	}

	public int getBeginingTime() {
		return beginingTime;
	}

	public void setBeginingTime(int beginingTime) {
		this.beginingTime = beginingTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + beginingTime;
		result = prime * result + ((idTimeSlot == null) ? 0 : idTimeSlot.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		return result;
	}



	// ------------------------------ equals ------------------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeSlot other = (TimeSlot) obj;
		if (beginingTime != other.beginingTime)
			return false;
		if (idTimeSlot == null) {
			if (other.idTimeSlot != null)
				return false;
		} else if (!idTimeSlot.equals(other.idTimeSlot))
			return false;
		if (isActive != other.isActive)
			return false;
		return true;
	}



	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "TimeSlot [idTimeSlot=" + idTimeSlot + ", beginingTime=" + beginingTime + ", isActive=" + isActive + "]";
	}

}