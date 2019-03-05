package com.kundan.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("aliens") //to specify resource path
public class AlienResource {

	AlienRepository repo=new AlienRepository();
	@GET //get request
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //to mention what we are producing
	public List<Alien> getAliens()
	{
		return repo.getAliens();
	}
	
	@GET //get request
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //client can receive both xml and json format data
	public Alien getAlien(@PathParam("id") int id)
	{
		return repo.getAlien(id);
	}
	
	
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //client can send both xml and json format data 
	public Alien createAlien(Alien a1)
	{
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
	
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //client can send both xml and json format data 
	public Alien updateAlien(Alien a1)
	{
		System.out.println(a1);
		repo.update(a1);
		return a1;
	}
	
	@Path("alien/{id}")
	@DELETE
	public Alien killAlien(@PathParam("id") int id)
	{
		Alien a=repo.getAlien(id);
		if(a.getId()!=0)
		repo.delete(id);
		
		return a;
	}
}
