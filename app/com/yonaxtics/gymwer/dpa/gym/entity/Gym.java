package com.yonaxtics.gymwer.dpa.gym.entity;

import java.util.List;

import com.yonaxtics.gymwer.dpa.client.entity.Client;
import com.yonaxtics.gymwer.dpa.plan.entity.Plan;
import com.yonaxtics.gymwer.set.location.entity.Location;
import com.yonaxtics.gymwer.util.base.entity.Entity;
/**
 * 
 * @author yonatan quintero
 * @version 0.1 (7/16/2014)
 *
 */
@SuppressWarnings("serial")
public class Gym extends Entity {
	
	public static final String KEY = "GYM_KEY";
	
	private String nit;
	private String name;	
	private Location location;	
	private List<Client> clientList;
	private List<Plan> planList;
	private boolean loaded;      
	
	public Gym(int id) {		
		super(id);		
	}
	
	public Gym(String name){		
		super(0);
		this.name = name;		
	}	

	@Override
	public boolean isEmpty() {	
		return name== null || name == "";
	}
	@Override
	public void copy(Entity entity) {
	   Gym gym = (Gym) entity;
	   this.active = gym.active;
	   this.clientList = gym.clientList;
	   this.created = gym.created;
	   this.id = gym.id;
	   this.location = gym.location;
	   this.nit = gym.nit;
	   this.name = gym.name;
	   this.planList = gym.planList;		
	}
	
	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public List<Plan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<Plan> planList) {
		this.planList = planList;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}





	
	

}
