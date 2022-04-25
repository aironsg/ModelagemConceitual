package com.dev.airon.cursomc.domain.enums;

public enum TypeClient {
	
	PESSOAFISICA(1, "Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private Integer cod;
	private String description;
	
	private TypeClient(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}



	public String getDescription() {
		return description;
	}
	
	public static TypeClient toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TypeClient x : TypeClient.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException();
		
		
	}


	

}
