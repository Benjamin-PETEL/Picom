//package fr.hb.benjamin.picom.business;
//
//import org.hibernate.validator.constraints.URL;
//
//import javax.persistence.Entity;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//public class AdvertPNG extends Advert{
//
//	// ----------------------------- Attributes ---------------------------------
//	private static final long serialVersionUID = 1L;
//	
//	@NotNull(message="Please give the link to your file")
//	@URL(message="please, give a valid URL")
//	@Pattern(regexp = "^https?://(?:[a-z0-9\\-]+\\.)+[a-z]{2,6}(?:/[^/#?]+)+\\.(?:Png|png|PNG)$", message="the url must end with png")
//	@Setter @Getter
//	private URL url;
//
//	
//	
//	// ------------------------------- Builder ----------------------------------
//	public AdvertPNG() {
//		super();
//	}
//
//
//	
//	// ----------------------------- toString -----------------------------------
//	@Override
//	public String toString() {
//		return super.toString() + "AdvertPNG [url=" + url + "]";
//	}	
//	
//}
