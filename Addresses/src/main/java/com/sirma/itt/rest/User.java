package com.sirma.itt.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
	@NamedQuery(name = "Names", query = "SELECT u.name FROM User as u"),
	@NamedQuery(name = "Users", query = "SELECT u FROM User as u")})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private ArrayList<String> addresses;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(ArrayList<String> addresses) {
		this.addresses = addresses;
	}
	
}
