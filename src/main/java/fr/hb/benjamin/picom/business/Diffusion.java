package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@NamedQuery(name="Diffusion.findAll", query="SELECT d FROM Diffusion d")
public class Diffusion implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private Long idDiffusion;

	@Temporal(TemporalType.TIMESTAMP)
	@Getter @Setter
	private Date dateHour;

	@ManyToOne
	@JoinColumn(name="idStop")
	private Stop stop;

	@ManyToOne
	@JoinColumn(name="idAdvert")
	private Advert advert;

	
	
	// ------------------------------- Builder ----------------------------------
	public Diffusion() {
	}


	
	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Diffusion [idDiffusion=" + idDiffusion + ", dateHour=" + dateHour + ", stop=" + stop + ", advert="
				+ advert + "]";
	}

	
	


}