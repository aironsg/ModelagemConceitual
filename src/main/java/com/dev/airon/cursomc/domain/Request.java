package com.dev.airon.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity(name = "Pedido")
public class Request  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cod")
	private Long id;
	
	@Column(name = "instante")
	private Date status;
	
	@ManyToOne
	@JoinColumn(name = "Endereco_entrega_id")
	private Anddress deliveryAnddress;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Client client;
	@OneToOne
	@JoinColumn(name = "Pedido_id")
	@MapsId
	private Payment payment;
	
	public Request() {
		
	}

	

	public Request(Date status, Anddress deliveryAnddress, Client client) {
		super();
		this.status = status;
		this.deliveryAnddress = deliveryAnddress;
		this.client = client;
		
	}
	
	



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getStatus() {
		return status;
	}



	public void setStatus(Date status) {
		this.status = status;
	}



	public Anddress getDeliveryAnddress() {
		return deliveryAnddress;
	}



	public void setDeliveryAnddress(Anddress deliveryAnddress) {
		this.deliveryAnddress = deliveryAnddress;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Payment getPayment() {
		return payment;
	}



	public void setPayment(Payment payment) {
		this.payment = payment;
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
		Request other = (Request) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	

}
