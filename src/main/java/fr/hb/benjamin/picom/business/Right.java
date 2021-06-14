package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="picomright")
// TODO rename the class
@NamedQuery(name="Right.findAll", query="SELECT r FROM Right r")
public class Right implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRight;

	@NotEmpty(message="Please provide a name")
	private String name;

	
	@ManyToMany(mappedBy="rights")
	private List<Role> roles;
	
	
	// ------------------------------- Builder ----------------------------------
	public Right() {
	}


	
	// ----------------------------- Set - Get ----------------------------------
	public Long getIdRight() {
		return idRight;
	}

	public void setIdRight(Long idRight) {
		this.idRight = idRight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Right [idRight=" + idRight + ", name=" + name + "]";
	}

}