package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private Long idBill;

	@Temporal(TemporalType.DATE)
	@Getter @Setter
	private Date billDate;

	@OneToMany(mappedBy="bill")
	@Getter @Setter
	private List<Purchase> purchases;

	@ManyToOne
	@JoinColumn(name="idUser")
	@Getter @Setter
	private User user;

	@ManyToOne
	@JoinColumn(name="idPaymentMean")
	@Getter @Setter
	private PaymentMean paymentMean;

	
	
	// ------------------------------- Builder ----------------------------------
	public Bill() {
	}


	
	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + ((idBill == null) ? 0 : idBill.hashCode());
		result = prime * result + ((paymentMean == null) ? 0 : paymentMean.hashCode());
		result = prime * result + ((purchases == null) ? 0 : purchases.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Bill other = (Bill) obj;
		if (billDate == null) {
			if (other.billDate != null)
				return false;
		} else if (!billDate.equals(other.billDate))
			return false;
		if (idBill == null) {
			if (other.idBill != null)
				return false;
		} else if (!idBill.equals(other.idBill))
			return false;
		if (paymentMean == null) {
			if (other.paymentMean != null)
				return false;
		} else if (!paymentMean.equals(other.paymentMean))
			return false;
		if (purchases == null) {
			if (other.purchases != null)
				return false;
		} else if (!purchases.equals(other.purchases))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Bill [idBill=" + idBill + ", billDate=" + billDate + ", paymentMean=" + paymentMean + "]";
	}
	
	

}