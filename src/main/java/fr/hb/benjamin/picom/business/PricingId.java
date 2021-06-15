package fr.hb.benjamin.picom.business;

import java.io.Serializable;

public class PricingId implements Serializable {

	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;
	
	private Long area;
	private Long timeSlot;
	
	
	// ----------------------------- Set - Get ----------------------------------
	public Long getArea() {
		return area;
	}
	public void setArea(Long area) {
		this.area = area;
	}
	public Long getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(Long timeSlot) {
		this.timeSlot = timeSlot;
	}
	
	
	
	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((timeSlot == null) ? 0 : timeSlot.hashCode());
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
		PricingId other = (PricingId) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (timeSlot == null) {
			if (other.timeSlot != null)
				return false;
		} else if (!timeSlot.equals(other.timeSlot))
			return false;
		return true;
	}
	
}
