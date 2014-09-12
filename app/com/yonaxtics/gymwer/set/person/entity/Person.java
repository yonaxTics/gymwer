package com.yonaxtics.gymwer.set.person.entity;

import com.yonaxtics.gymwer.dpa.gym.entity.Gym;
import com.yonaxtics.gymwer.set.location.entity.Location;
import com.yonaxtics.gymwer.set.picture.entity.Picture;
import com.yonaxtics.gymwer.set.user.entity.User;
import com.yonaxtics.gymwer.util.base.entity.Entity;

/**
 * 
 * @author yonatan quintero
 * @version 0.1 (7/16/2014)
 *
 */
public class Person  extends Entity {

	private static final long serialVersionUID = 1L;
	public final static int FEMALE = 6;
	public final static int  MALE = 5;
	
	private User user;
	private Location location;	
	private String document;
	private String name;
	private Gym gym;
    private Picture picture;
	
	public Person(int id) {		
		super(id);		
	}
		
	public Person(User user,Gym gym){		
		super(0);		
		this.user = user;
		this.gym = gym;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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


	public Gym getGym() {
		return gym;
	}


	public void setGym(Gym gym) {
		this.gym = gym;
	}






	public Picture getPicture() {
		return picture;
	}






	public void setPicture(Picture picture) {
		this.picture = picture;
	}














	

}
