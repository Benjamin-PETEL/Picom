package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private Long idRole;

	@NotEmpty(message="Please provide a name for the role")
	@Getter @Setter
	private String name;

	@OneToMany(mappedBy="role")
	@Setter @Getter
	private List<User> users;
	
	@ManyToMany
	@Getter @Setter
	private List<Right> rights;
	
	// ------------------------------- Builder ----------------------------------
	public Role() {
	}


	
	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", name=" + name + "]";
	}
	
}