package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name="Purchase.findAll", query="SELECT p FROM Purchase p")
public class Purchase implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private long idPurchase;

	@Getter @Setter
	private float amount;

	@ManyToOne
	@JoinColumn(name="idBill")
	@Getter @Setter
	private Bill bill;

	@ManyToOne
	@JoinColumn(name="idArea")
	@Getter @Setter
	private Area area;

	@ManyToOne
	@JoinColumn(name="idTimeSlot")
	@Getter @Setter
	private TimeSlot timeSlot;

	@ManyToOne
	@JoinColumn(name="idAdvert")
	@Getter @Setter
	private Advert advert;

	
	
	// ------------------------------- Builder ----------------------------------
	public Purchase() {
	}


	
	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Purchase [idPurchase=" + idPurchase + ", amount=" + amount + ", bill=" + bill + ", area=" + area
				+ ", timeSlot=" + timeSlot + ", advert=" + advert + "]";
	}

	
}