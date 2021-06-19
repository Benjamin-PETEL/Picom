package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery(name="Localisation.findAll", query="SELECT l FROM Localisation l")
public class Localisation implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLocalisation;

	private String latitude;

	private String longitude;

	
	
	// ------------------------------- Builder ----------------------------------
	public Localisation() {
	}

	
	
	public Localisation(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}



	// ----------------------------- Set - Get ----------------------------------
	public Long getIdLocalisation() {
		return idLocalisation;
	}

	public void setIdLocalisation(Long idLocalisation) {
		this.idLocalisation = idLocalisation;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	
	
	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLocalisation == null) ? 0 : idLocalisation.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		return result;
	}
	
	

	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Localisation [idLocalisation=" + idLocalisation + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
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
		Localisation other = (Localisation) obj;
		if (idLocalisation == null) {
			if (other.idLocalisation != null)
				return false;
		} else if (!idLocalisation.equals(other.idLocalisation))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		return true;
	}

}