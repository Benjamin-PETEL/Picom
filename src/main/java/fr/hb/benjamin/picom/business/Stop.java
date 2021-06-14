package fr.hb.benjamin.picom.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name="Stop.findAll", query="SELECT s FROM Stop s")
public class Stop implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStop;

	private String ipAdress;

	@NotNull(message="Please provide a name to the stop")
	@Column(unique = true)
	private String name;

	@ManyToOne
	@JoinColumn(name="idLocalisation")
	@NotNull(message="Please provide a localisation")
	private Localisation localisation;

	@ManyToOne
	@JoinColumn(name="idArea")
	@NotNull(message="Please provide an area")
	private Area area;

	
	
	// ------------------------------- Builder ----------------------------------
	public Stop() {
	}


	
	// ----------------------------- Set - Get ----------------------------------
	public Long getIdStop() {
		return idStop;
	}

	public void setIdStop(Long idStop) {
		this.idStop = idStop;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Localisation getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	
	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((idStop == null) ? 0 : idStop.hashCode());
		result = prime * result + ((ipAdress == null) ? 0 : ipAdress.hashCode());
		result = prime * result + ((localisation == null) ? 0 : localisation.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Stop other = (Stop) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (idStop == null) {
			if (other.idStop != null)
				return false;
		} else if (!idStop.equals(other.idStop))
			return false;
		if (ipAdress == null) {
			if (other.ipAdress != null)
				return false;
		} else if (!ipAdress.equals(other.ipAdress))
			return false;
		if (localisation == null) {
			if (other.localisation != null)
				return false;
		} else if (!localisation.equals(other.localisation))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Stop [idStop=" + idStop + ", ipAdress=" + ipAdress + ", name=" + name + ", localisation=" + localisation
				+ ", area=" + area + "]";
	}
}