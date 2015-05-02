package com.sirma.itt.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class UserDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Add users in database.
	 */
	public String registerUser(String name) {
		List<User> users = createQuery();
		for (User user : users) {
			if(user.getName().equals(name)){
				return "User " + name + " already registered!!!";
			}
		}
		User user = new User();
		user.setName(name);
		user.setAddresses(new ArrayList<String>());
		entityManager.persist(user);
		return "user " + name + " registered.";
	}

	public String removeUser(String name){
		List<User> users = createQuery();
		for (User user : users) {
			if(user.getName().equals(name)){
				entityManager.remove(user);
				return "User " + name + " removed.";
			}
		}
		return "User with " + name + " doesn't exist.";
	}
	
	public String getAddress(String name){
		List<User> users = createQuery();
		for (User user : users) {
			if(user.getName().equals(name)){
				return user.getAddresses().toString();
			}
		}
		return "User with name: " + name + " does not exist.";
	}
	
	public String addAddress(String name, String address){
		List<User> users = createQuery();
		for(User user : users){
			if(user.getName().equals(name)){
				user.getAddresses().add(address);
			}
		}
		return address;
	}
	
	public String deleteAddress(String name, String address){
		List<User> users = createQuery();
		for(User user : users){
			if(user.getName().equals(name)){
				user.getAddresses().remove(address);
			}
		}
		return address;
	}

	private List<User> createQuery() {
		TypedQuery<User> query = entityManager.createNamedQuery(
				"Users", User.class);
		List<User> users = query.getResultList();
		return users;
	}
	
}
