	package com.yonaxtics.gymwer.dpa.gym.controller;

import static com.yonaxtics.gymwer.sec.crypto.aes.Sec.dec;
import static com.yonaxtics.gymwer.sec.crypto.aes.Sec.enc;

import java.util.Map;

import play.libs.Json;
import play.mvc.Result;
import views.html.dpa.gym.gym;

import com.yonaxtics.gymwer.dpa.gym.entity.Gym;
import com.yonaxtics.gymwer.dpa.gym.logic.GymLogic;
import com.yonaxtics.gymwer.sec.securedController;
import com.yonaxtics.gymwer.set.location.logic.LocationLogic;
import com.yonaxtics.gymwer.set.master.logic.MasterLogic;
import com.yonaxtics.gymwer.set.user.entity.User;
/**
 * 
 * @author yonatan quintero
 * @version 0.1 (9/8/2014)
 *
 */
public class GymControl extends securedController {
	
	public static Result gym(){
		byte result = authenticated();
		if(result == AUTHENTICATED){
			return ok(gym.render());
		}else{			
			return onUnauthorized(result);
		}		
	}	
	
	public static Result load(){	
		byte result = authenticated();
		if(result == AUTHENTICATED){			
			User user = getUserLoggedIn();
 			if(user!=null){
 				if(GymLogic.load(user.getGym())){ 					
 					return ok(enc(Json.toJson(user.getGym()).toString()));	
 				}else{
 					return ok("Error trying Load Gym!");
 				}					
			}else{
				return closeSession();	
			}
		}else{
			return onUnauthorized(result);
		}				
	}
	
	public static Result save(){		
		byte result = authenticated();
		if(result == AUTHENTICATED){
			String message = null;
			Gym gym = getCurrentGym();
			if(gym!=null){
				final Map<String,String[]>data = request().body().asFormUrlEncoded();
				gym.setName(dec(data.get("txtName")[0]));		
			    if(!gym.getName().isEmpty()){	    	
			    	gym.getLocation().getPhone().setPhone((dec(data.get("txtPhone")[0])));			
					if(MasterLogic.save(gym.getLocation().getPhone()) ){
						gym.getLocation().getAddress().setAddress(dec(data.get("txtAddress")[0]));				
					    if(MasterLogic.save(gym.getLocation().getAddress())){			    	
					    	if(LocationLogic.save(gym.getLocation())){
					    	    gym.setName(dec(data.get("txtNit")[0]));			    	   
					    	   if(GymLogic.update(gym)){
					    			return ok(SUCCESS_REQUEST);		
					    	   }else{
					    			message = "Error trying to save Gym!";
					    		}				    				    	
					    	}else{
					    	    message = "Error trying to save Location!";	
					    	}	
					    }else{
					    	message = "Error trying to save Address!";	
					    }		
				  }else{
					  message = "Error trying to save Phone!";
				  }		   
			    }else {
			    	message = "The user Name is required and can't empty";
			    }	
				return ok(message);
			
			}else{
				return closeSession(); 
			}
			
		}else {
			return onUnauthorized(result);
		}

	}
	
	
	
}
