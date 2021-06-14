package fr.hb.benjamin.picom.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@NamedQuery(name="PaymentMean.findAll", query="SELECT p FROM PaymentMean p")
public class PaymentMean implements Serializable {
	
	// ----------------------------- Attributes ---------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private long idPaymentMean;

	@Pattern(regexp="^[0-9]{3}$", message="The CVV is the 3 figures at the back of your card")
	@Getter @Setter
	private String cvv;

	@Temporal(TemporalType.DATE)
	@Future(message="Your card has expired")
	@Getter @Setter
	private Date expirationDate;

	@CreditCardNumber(message="Card number not valid")
	@Getter @Setter
	private String cardNumber;

	@OneToMany
	@JsonIgnore
	@Getter @Setter
	private List<Bill> bills;
	
	@ManyToMany
	private List<User> users;

	
	
	// ------------------------------- Builder ----------------------------------
	public PaymentMean() {
	}


	
	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "PaymentMean [idPaymentMean=" + idPaymentMean + ", cvv=" + cvv + ", expirationDate=" + expirationDate
				+ ", cardNumber=" + cardNumber + "]";
	}

}