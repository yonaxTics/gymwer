package com.yonaxtics.gymwer.set.action.entity;

import com.yonaxtics.gymwer.set.module.entity.Module;
import com.yonaxtics.gymwer.util.base.entity.Entity;

/** 
 * Clase     : Action.java<br/>
 * Copyright : (c) 2014<br/>
 * Company   : yonaxtics<br/>
 * date      : Aug 13, 2014<br/> 
 * User      : yonatan<br/> 
 * @author Yonatan Alexis Quintero Rodriguez<br/>
 */

public class Action extends Entity {

	
	private String description;
	private String url;
	private String ico;
	private Module module;	
	
	
	/**
	 * @param id
	 */
	public Action(int id) {
		
		super(id);
		
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	/**
	 * @return the ico
	 */
	public String getIco() {
		return ico;
	}


	/**
	 * @param ico the ico to set
	 */
	public void setIco(String ico) {
		this.ico = ico;
	}


	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}


	/**
	 * @param module the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	
}
