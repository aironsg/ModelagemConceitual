package com.dev.airon.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.dev.airon.cursomc.domain.enums.PaymentStatus;

@Entity(name = "Pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cod")
	private Long id;	
	private PaymentStatus status;
	@OneToOne(mappedBy = "payment")
	private Request request;

	public Payment() {
		
	}


	public Payment(PaymentStatus status, Request request) {
		super();
		this.status = status;
		this.request = request;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	


	public Request getRequest() {
		return request;
	}


	public void setRequest(Request request) {
		this.request = request;
	}


	public PaymentStatus getStatus() {
		return status;
	}


	public void setStatus(PaymentStatus status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
