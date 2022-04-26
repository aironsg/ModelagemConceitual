package com.dev.airon.cursomc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dev.airon.cursomc.domain.enums.PaymentStatus;

@Entity(name = "Pagamento_com_boleto")
public class PaymentWithTicket extends Payment {
	
	
	private static final long serialVersionUID = 1L;
	@Column(name = "Data_vencimento")
	private Date dueDate;
	@Column(name = "Data_pagamento")
	private Date dateOfPayment;
	
	public PaymentWithTicket() {
		
	}

	public PaymentWithTicket(PaymentStatus status, Request request, Date dueDate, Date dateOfPayment) {
		super(status, request);
		this.dueDate = dueDate;
		this.dateOfPayment = dateOfPayment;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	
	
	
	
	

}
