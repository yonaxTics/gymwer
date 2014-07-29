package com.yonaxtics.gymwer.set.person.logic;

import com.yonaxtics.gymwer.set.person.entity.Person;
import com.yonaxtics.gymwer.set.person.dao.*;


public class PersonLogic {

	
	public static boolean create(Person person) {
		
		boolean result = false;	
		
		 
		if(person != null && !person.exists() && !person.getEmail().isEmpty()){	 		    	  
		    		  
              result = PersonDao.create(person);
		}
	      
	    return result;
	}
	
	
	
	
}