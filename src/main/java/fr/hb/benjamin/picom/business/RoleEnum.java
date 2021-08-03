package fr.hb.benjamin.picom.business;

public enum RoleEnum {

		ROLE_ADMIN (1, "administrator"),
		ROLE_USER (2, "user");
	
	// ----------------------------- Attributes ---------------------------------
    private long id;
	private String name;
	
	
	
	// ---------------------------- Constructor ---------------------------------
	private RoleEnum(long id, String name) {
		this.id = id;
		this.name = name;
	}


	// ----------------------------- Set - Get ----------------------------------
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
