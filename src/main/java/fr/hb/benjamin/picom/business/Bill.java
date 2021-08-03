package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBill;

	@Temporal(TemporalType.DATE)
	private Date billDate;

	@OneToMany(mappedBy="bill")
	private List<Purchase> purchases;

	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	@ManyToOne
	@JoinColumn(name="idPaymentMean")
	private PaymentMean paymentMean;

	
	
	// ------------------------------- Constructor ----------------------------------
	public Bill() {
	}


	
	// ----------------------------- Set - Get ----------------------------------
	public Long getIdBill() {
		return idBill;
	}

	public void setIdBill(Long idBill) {
		this.idBill = idBill;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PaymentMean getPaymentMean() {
		return paymentMean;
	}

	public void setPaymentMean(PaymentMean paymentMean) {
		this.paymentMean = paymentMean;
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