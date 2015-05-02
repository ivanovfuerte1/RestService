package com.sirma.itt.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("addressdirectory")
public class UserRequests {
	
	@Inject
	private UserDao userDao;

	@GET
	@Path("addresses/{user}")
	public String getAddress(@PathParam("user") String user){
		return userDao.getAddress(user);
	}
	
	@PUT
	@Path("addresses/{user}/{address}")
	public String addAddress(@PathParam("user") String user, @PathParam("address") String address){
		return userDao.addAddress(user, address);
		
	}
	
	@DELETE
	@Path("addresses/{user}/{address}")
	public String deleteAddress(@PathParam("user") String user, @PathParam("address") String address){
		return userDao.deleteAddress(user, address);
	}
	
	@POST
	@Path("users/{user}")
	public String registerUser(@PathParam("user") String user){
		return userDao.registerUser(user);
	}
	
	@DELETE
	@Path("users/{user}")
	public String deleteUser(@PathParam("user") String user){
		return userDao.removeUser(user);
	}
	
}
