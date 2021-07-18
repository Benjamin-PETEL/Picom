package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

//import org.locationtech.jts.geom.Point

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.vividsolutions.jts.geom.Polygon;
//
//import org.hibernate.annotations.Type;

//import org.springframework.data.geo.Polygon;

@Entity
@NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
public class Area implements Serializable {

	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArea;
 
	
//	@Type(type="org.hibernate.spatial.GeometryType")
//	@Column(columnDefinition = "Polygon")
//	private Polygon contour;

	@NotBlank(message="Please give a name to the area")
	@Column(unique = true)
	private String name;

	@OneToMany(mappedBy = "area")
	@JsonIgnore
	private List<Stop> stops;

	@JsonIgnore
	@OneToMany(mappedBy = "area")
	private List<Pricing> pricing;

	// ------------------------------- Constructor  ----------------------------------
	
	public Area() {
	}

	// ----------------------------- Set - Get ----------------------------------
	public Long getIdArea() {
		return idArea;
	}

	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

	public List<Pricing> getPricing() {
		return pricing;
	}

	public void setPricing(List<Pricing> pricing) {
		this.pricing = pricing;
	}

	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idArea == null) ? 0 : idArea.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pricing == null) ? 0 : pricing.hashCode());
		result = prime * result + ((stops == null) ? 0 : stops.hashCode());
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
		Area other = (Area) obj;
		if (idArea == null) {
			if (other.idArea != null)
				return false;
		} else if (!idArea.equals(other.idArea))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pricing == null) {
			if (other.pricing != null)
				return false;
		} else if (!pricing.equals(other.pricing))
			return false;
		if (stops == null) {
			if (other.stops != null)
				return false;
		} else if (!stops.equals(other.stops))
			return false;
		return true;
	}

	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Area [idArea=" + idArea + ", name=" + name + ", stops=" + stops + ", pricing="
				+ pricing + "]";
	}

}