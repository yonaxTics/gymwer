package com.yonaxtics.gymwer.set.user.logic;

import com.yonaxtics.gymwer.set.user.dao.UserDao;
import com.yonaxtics.gymwer.set.user.entity.User;
/**
 * 
 * @author yonatan quintero
 * @version 0.1 (7/16/2014)
 *
 */
public  class   UserLogic  {


	public static boolean create(User user) {		
		boolean result = false;					 
		if(user != null && !user.exists()){		    		  
             result = UserDao.create(user);	    	
		}	      
	    return result;
	}
	
	public static boolean update(User user){
		boolean result = false;
		if(user != null && user.exists()){
			if(user.getRole().exists() && user.getDefaultAction().exists()){
				result = UserDao.update(user);	
			}			
		}
		return result;
	}

	/**
	 * @param user
	 * @return
	 */
	public static boolean load(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param user
	 * @return
	 */
	public static boolean relationalWithGym(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

	

	
	
}
