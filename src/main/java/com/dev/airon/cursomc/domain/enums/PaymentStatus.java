package com.dev.airon.cursomc.domain.enums;

public enum PaymentStatus {
	
	EFETUADO(1,"Efetuado"),
	PENDENTE (2, "Pendente"),
	CANCELADO(3, "Cancelado");
	
	private Integer cod;
	private String description;
	
	private PaymentStatus() {
		
	}

	

	
	private PaymentStatus(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}




	public Integer getCod() {
		return cod;
	}




	public void setCod(Integer cod) {
		this.cod = cod;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public static PaymentStatus toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(PaymentStatus x : PaymentStatus.values()) {
			if(cod.equals(x.cod)) {
				return x;
			}
		}
		
		throw new IllegalArgumentException();
	}

}
