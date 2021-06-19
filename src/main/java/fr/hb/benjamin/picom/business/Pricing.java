package fr.hb.benjamin.picom.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;

@Entity
@NamedQuery(name="Pricing.findAll", query="SELECT p FROM Pricing p")
@IdClass(PricingId.class)
public class Pricing implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L; 
	
	@Id
	@ManyToOne
	@JoinColumn(name="idArea")
	private Area area;

	@Id
	@ManyToOne
	@JoinColumn(name="idTimeSlot")
	private TimeSlot timeSlot;

	@Min(value=0, message="please provide a positive value")
	private float price;
	
	
	// ------------------------------- Builder ----------------------------------
	public Pricing() {
	}

	
	
	// ----------------------------- Set - Get ----------------------------------	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}


	
	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + Float.floatToIntBits(price);
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
		Pricing other = (Pricing) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (timeSlot == null) {
			if (other.timeSlot != null)
				return false;
		} else if (!timeSlot.equals(other.timeSlot))
			return false;
		return true;
	}



	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Pricing [area=" + area + ", timeSlot=" + timeSlot + ", price=" + price + "]";
	}	
	
}