package com.yonaxtics.gymwer.dpa.role.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import play.Logger;

import com.yonaxtics.gymwer.sec.permission.entity.*;
import com.yonaxtics.gymwer.set.action.entity.Action;
import com.yonaxtics.gymwer.set.master.entity.MasterValue;

/**
 * 
 * @author yonatan quintero
 * @version 0.1 (7/16/2014)
 *
 */
@SuppressWarnings("serial")
public class Role extends MasterValue {

	public final static int SUPER_ADMIN = 4;
	public final static int ADMIN = 33;
	
	public final static String KEY = "ROLE_KEY";
	
	private List<Permission> permissionsLoad;
	private List<Permission> permissionsCreate;
	private List<Permission> permissionsUpdate;
	private List<Permission> permissionsDelete;
	private List<Permission> permissionsChangeStatus;
	private boolean permissonsReady;
	
	public Role(int id) {		
		super(id);		
	}
	
	public Role(int id, String name){		
		super(id);
		setValue1(name);
	}	
	
	public Role(String name) {		
		super(0);
		setValue1(name);
	}
	
	public void initPermissions(){
		permissionsLoad = new ArrayList<Permission>();
		permissionsCreate = new ArrayList<Permission>();
		permissionsUpdate = new ArrayList<Permission>();
		permissionsDelete = new ArrayList<Permission>();
		permissionsChangeStatus = new ArrayList<Permission>();
		permissonsReady = true;
	}
	

	public void addChildrenToParentsModules(){			
		try{	
			  List<Action> actParents = permissionsLoad.stream().map(Permission::getAction).filter(act->act.getModule().getModuleType().isParent()).collect(Collectors.toList()); 	  
		      if(actParents.size() > 0){				
				List<Action> actChildren = permissionsLoad.stream().map(Permission::getAction).filter(act->act.getModule().getModuleType().isChild()).collect(Collectors.toList());				
				actChildren.stream().parallel().forEach(child -> {			
			      actParents.stream().parallel().forEach(parent->{				
				    if(child.getModule().getParent().equals(parent.getModule())){					
						child.getModule().releaseParent();				    		
						parent.getModule().getChildren().add(child);				    		
					} 
				  });
				});
			  }		    
		      permissionsLoad.removeIf(p -> p.getAction().getModule().getModuleType().isChild());	
		}catch(Exception e){
			Logger.error(e.getMessage());
		}      
	}
	
	public void copy(Role role){
		id = role.id;
		value1 = role.value1;
		permissonsReady = role.permissonsReady;
		if(permissonsReady){
			permissionsLoad = role.permissionsLoad;
			permissionsCreate = role.permissionsCreate;
			permissionsUpdate = role.permissionsUpdate;
			permissionsDelete = role.permissionsDelete;
			permissionsChangeStatus = role.permissionsChangeStatus;
		}
	}
	
	public void updateActionLoadUser(){
		int n = permissionsLoad.size();
		int i = 0;
		boolean result = false;
		do {
			Action action = permissionsLoad.get(i++).getAction();
			if(action.getId() == Action.LOAD_USER){
				action.getModule().setDescription(getLoginName());
				result = true;
			}
		} while (!result && i<n);
	}
	
	public boolean isSuperAdmin(){
		return id == Role.SUPER_ADMIN;
	}
	
	public boolean isAuthorizedToLoadPlans() {
		boolean result = isSuperAdmin();
		int n = permissionsLoad.size();
		int i = 0;
		while (!result && i < n) {
			if (Action.LOAD_PLANS == permissionsLoad.get(i++).getAction().getId()) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean isAuthorizedToLoadGym() {
		boolean result = isSuperAdmin();
		int n = permissionsLoad.size();
		int i = 0;
		while (!result && i < n) {
			if (Action.LOAD_GYM == permissionsLoad.get(i++).getAction().getId()) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean isAuthorizedToUpdateUser() {
		boolean result = isSuperAdmin();
		int n = permissionsUpdate.size();
		int i = 0;
		while (!result && i < n) {
			if (Action.UPDATE_USER == permissionsUpdate.get(i++).getAction().getId()) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean isAuthorizedToUpdateGym() {
		boolean result = isSuperAdmin();
		int n = permissionsUpdate.size();
		int i = 0;
		while (!result && i < n) {
			if (Action.UPDATE_GYM == permissionsUpdate.get(i++).getAction().getId()) {
				result = true;
			}
		}
		return result;
	}
	
	public String getName(){		
		return getValue1();
	}
	
	public void setName(String name){		
		setValue1(name);
	}
	
	public String getLoginName(){
		return value2;
	}
	
	public void setLoginName(String loginName){
		value2 = loginName;
	}
	
	public String getGymName(){
		return value3;
	}
	
	public void setGymName(String gymName){
		value3 = gymName;
	}

	public List<Permission> getPermissionsLoad() {
		return permissionsLoad;
	}

	public void setPermissionsLoad(List<Permission> permissionsLoad) {
		this.permissionsLoad = permissionsLoad;
	}

	public List<Permission> getPermissionsCreate() {
		return permissionsCreate;
	}

	public void setPermissionsCreate(List<Permission> permissionsCreate) {
		this.permissionsCreate = permissionsCreate;
	}

	public List<Permission> getPermissionsUpdate() {
		return permissionsUpdate;
	}

	public void setPermissionsUpdate(List<Permission> permissionsUpdate) {
		this.permissionsUpdate = permissionsUpdate;
	}

	public List<Permission> getPermissionsDelete() {
		return permissionsDelete;
	}

	public void setPermissionsDelete(List<Permission> permissionsDelete) {
		this.permissionsDelete = permissionsDelete;
	}

	public List<Permission> getPermissionsChangeStatus() {
		return permissionsChangeStatus;
	}

	public void setPermissionsChangeStatus(List<Permission> permissionsChangeStatus) {
		this.permissionsChangeStatus = permissionsChangeStatus;
	}

	public boolean isPermissonsReady() {
		return permissonsReady;
	}

	public void setPermissonsReady(boolean permissonsReady) {
		this.permissonsReady = permissonsReady;
	}



	
}
