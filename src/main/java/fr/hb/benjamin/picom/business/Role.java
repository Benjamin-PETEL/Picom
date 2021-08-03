package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable{
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idRole;
	
	private String name;
	
	@ManyToMany(mappedBy="roles", fetch=FetchType.EAGER)
	private List<User> users;
	
	// ------------------------------- Constructor ----------------------------------
	public Role() {
		super();
	}
	
	
	
	// ----------------------------- Set - Get ----------------------------------
	public Long getIdRole() {
		return idRole;
	}
		
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Role other = (Role) obj;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	
	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", name=" + name + ", users=" + users.size() + "]";
	}

}
