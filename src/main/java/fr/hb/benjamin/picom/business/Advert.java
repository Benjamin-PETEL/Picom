package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
// TODO faire les classes fille: verifier si il ne faut pas utiliser un design pattern strategy
@NamedQuery(name="Advert.findAll", query="SELECT a FROM Advert a")
public abstract class Advert implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private Long idAdvert;

	@Temporal(TemporalType.DATE)
	@Future(message="The start date must be in the future")
	@Getter @Setter	
	private Date startDate;

	@NotBlank(message="Please give a duration")
	@Getter @Setter	
	private int duration;

	@OneToMany(mappedBy="advert")
	@Getter @Setter	
	private List<Purchase> purchases;
	
	
	
	// ------------------------------- Builder ----------------------------------
	public Advert() {
	}



	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Advert [idAdvert=" + idAdvert + ", startDate=" + startDate + ", duration=" + duration + "]";
	}
	
}