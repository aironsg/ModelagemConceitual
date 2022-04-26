package com.dev.airon.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dev.airon.cursomc.domain.enums.TypeClient;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Cliente")
public class Client implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cod")
	private Long id;
	
	@Column(name = "Nome", length = 50)
	private String name;
	
	@Column(name = "email", length = 50)
	private String email;
	
	@Column(name = "Cpf_ou_Cnpj", length = 20)
	private String cpfOrCnpj;
	
	@Column(name = "Tipo_cliente")
	private Integer type;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "client")
	private List<Anddress> anddress = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> phones = new HashSet<>();
	
	@OneToMany(mappedBy = "client")
	private List<Request> requests = new ArrayList<>();
	
	public Client() {
		
	}

	public Client(String name, String email, String cpfOrCnpj, TypeClient type) {
		super();
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.type = type.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public TypeClient getType() {
		return TypeClient.toEnum(type);
	}

	public void setType(TypeClient type) {
		this.type = type.getCod();
	}
	
	

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	

	public List<Anddress> getAnddress() {
		return anddress;
	}

	public void setAnddress(List<Anddress> anddress) {
		this.anddress = anddress;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
