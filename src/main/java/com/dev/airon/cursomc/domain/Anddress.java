package com.dev.airon.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Endereco")
public class Anddress implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cod")
	private Long id;
	
	@Column(name = "Logradouro" , length = 100)
	private String publicPlace;
	@Column(name = "Bairro", length = 50)
	private String district;
	
	@Column(name = "Numero")
	private String number;
	@Column(name = "complemento",  length = 50)
	private String complement;
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "Cliente_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "Cidade_id")
	private City city;
	
	public Anddress() {
		
	}

	public Anddress(String publicPlace, String district, String number, String complement, String cep, Client client,
			City city) {
		super();
		this.publicPlace = publicPlace;
		this.district = district;
		this.number = number;
		this.complement = complement;
		this.cep = cep;
		this.client = client;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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
		Anddress other = (Anddress) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
