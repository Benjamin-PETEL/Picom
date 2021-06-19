package fr.hb.benjamin.picom.business;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class AdvertPNG extends Advert{

	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Please give the link to your file")
	//@URL(message="please, give a valid URL")
	//@Pattern(regexp = "^https?://(?:[a-z0-9\\-]+\\.)+[a-z]{2,6}(?:/[^/#?]+)+\\.(?:Png|png|PNG)$", message="the url must end with png")
	private String url;

	
	
	// ------------------------------- Builder ----------------------------------
	public AdvertPNG() {
		super();
	}


	
	// ----------------------------- Set - Get ----------------------------------	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}


	
	// ------------------------------ equals ------------------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdvertPNG other = (AdvertPNG) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}



	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return super.toString() + "AdvertPNG [url=" + url + "]";
	}	
	
}
