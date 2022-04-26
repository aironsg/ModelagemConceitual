package com.dev.airon.cursomc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dev.airon.cursomc.domain.enums.PaymentStatus;
@Entity(name = "Pagamento_com_cartao")
public class PaymentByCard  extends Payment{

	
	private static final long serialVersionUID = 1L;
	@Column(name = "numero_parcelas")
	private Integer numberOfInstallments;
	
	public PaymentByCard() {
		
	}
	

	public PaymentByCard(PaymentStatus status, Request request, Integer numberOfInstallments) {
		super(status, request);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}
	
	
	
	

}
