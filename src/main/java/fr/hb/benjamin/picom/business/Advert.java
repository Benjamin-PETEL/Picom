package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQuery(name="Advert.findAll", query="SELECT a FROM Advert a")
public abstract class Advert implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdvert;

	//@Temporal(TemporalType.DATE)
	//@Future(message="The start date must be in the future")
	private LocalDate startDate;

	//@Temporal(TemporalType.DATE)
	//@Future(message="The end date must be in the future")
	private LocalDate endDate;

	@OneToMany(mappedBy="advert")
	@JsonIgnore	
	private List<Purchase> purchases;
	
	
	
	// ------------------------------- Constructor ----------------------------------
	public Advert() {
	}


	
	// ----------------------------- Set - Get ----------------------------------
	public Long getIdAdvert() {
		return idAdvert;
	}

	public void setIdAdvert(Long idAdvert) {
		this.idAdvert = idAdvert;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}



	// ----------------------------- hashCode -----------------------------------	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((idAdvert == null) ? 0 : idAdvert.hashCode());
		result = prime * result + ((purchases == null) ? 0 : purchases.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Advert other = (Advert) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (idAdvert == null) {
			if (other.idAdvert != null)
				return false;
		} else if (!idAdvert.equals(other.idAdvert))
			return false;
		if (purchases == null) {
			if (other.purchases != null)
				return false;
		} else if (!purchases.equals(other.purchases))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}


	
	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Advert [idAdvert=" + idAdvert + ", startDate=" + startDate + ", endDate=" + endDate + ", purchases="
				+ purchases + "]";
	}
	
}