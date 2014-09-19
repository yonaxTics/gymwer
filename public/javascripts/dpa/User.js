require.config({
	
	
	baseUrl : 'assets/javascripts',
	
	
	paths : {
		
	    Aes :       'play/yonaxtics/google/aes',	
		Constants : 'play/yonaxtics/Constants',
		Play :      'play/yonaxtics/Play',		
		Json :      'play/yonaxtics/Json',
		Nav :       'play/yonaxtics/Nav'	,
		Select :    'play/yonaxtics/Select',
		List :      'set/List',
		Notify:     'play/yonaxtics/Notify',
		FormOk:     'play/yonaxtics/FormOk'

			
	}
});

/*
 * ! User.js Copyright 2014 YonaxTics, Inc. Licensed under
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/*
 * ========================================================================
 * User.js yonax73@gmail.com
 * ========================================================================
 * Copyright 2014 yonaxTics, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the 'License'); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * ========================================================================
 */
/*
 * ========================================================================
 * Version 0.1: 17-August-2014 Created on : 17-August-2014 Author : Yonatan Alexis
 * Quintero Rodriguez
 * ========================================================================
 */




requirejs(['Aes', 'Constants', 'Play','Json','Nav','Select','List','Notify','FormOk'],function(Aes,Constants, Play, Json,Nav,Select,List,Notify,FormOk ) {

	
	
/* ==================================================================================================================
 * REGION ATTRIBUTES
 * ===================================================================================================================*/
	var btnSave = Play.getId('btnSave');	
	var frmUser = Play.getId('frmUser');	
	var notify = new Notify(Play.getId('notify'));	
	var frmUserOk = new FormOk(frmUser);
	var selectPageHome= null;
	var User = null;
/* ==================================================================================================================
 * REGION READY
 * ===================================================================================================================
 */	
	if(Play.ready()){		
		init();		
	}	
/* ==================================================================================================================
 * REGION LOAD
 * ===================================================================================================================
 */		
	function load(){		
		var xhr = new XMLHttpRequest();		
		xhr.onreadystatechange = function () {		       
			  if (this.readyState === Constants.READYSTATE_COMPLETE) {				  						
				  if(this.status === Constants.STATUS_OK){									  
					  User = Json.parse(this.responseText);
					  localStorage.setItem(Constants.LOCALSTORAGE_REQUEST_LOAD_PROFILE,JSON.stringify(User));
					  fill(User);						
				   } 					  
			  }		  
		}
		xhr.open('GET','/loadUser');
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
		xhr.send();		
		xhr.timeout = Constants.TIME_OUT;
		xhr.ontimeout = function () {
			 notify.danger('Time out!!!');									
		}	
     }	
	function loadList(){		
		List.url();
	}	
	function fill(User){          
		  if(User.picture != null){
			Play.getId('userPicture').src =  Play.base64Blob(User.picture.mime, User.picture.src);
		  }
		  Play.getId('txtNameUser').value = User.user.name;
		  Play.getId('txtRole').textContent = User.user.role.name;
		  selectPageHome = new Select(Play.getId('selectPageHome'),List.url());
	      selectPageHome.init(User.user.defaultAction.id);	
		  Play.getId('txtEmail').textContent = User.user.email;
		  Play.getId('nameUser').textContent = User.user.name;
		  Play.getId('txtFullName').value = User.name;
		  Play.getId('txtDocument').value = User.document;
		  Play.getId('txtAddress').value = User.location.address.address;
		  Play.getId('txtPhone').value = User.location.phone.phone;		
	}
/* ==================================================================================================================
 * REGION UPLOAD PICTURE
 * ===================================================================================================================
 */		
   function uploadPicture(){	   
		  Play.getId('uploadImage').onclick = function(){			  
			  Play.getId('fileselect').click();
		  }		  
		  Play.getId('userPicture').onclick = function(){			  
			  Play.getId('fileselect').click();
		  }		  
		  Play.getId('fileselect').onchange = function(e){			  
			  handleFileSelect(e);
		  }
   }	
   function handleFileSelect(evt) {		  
		    var picture = evt.target.files[0];
		    var xhr = null;
		    var reader = null;		    
		    if(picture.type.match('image.*')){		    	
		    	if(picture.size <= 65535){		    		
					    xhr = new XMLHttpRequest();						
						xhr.onreadystatechange = function () {	
							  notify.wait('Upload picture	...');	
							  Play.getId('fileselect').disabled = true;
							  if (this.readyState === Constants.READYSTATE_COMPLETE) {	
								  Play.getId('fileselect').disabled = false;
								  if(this.status === Constants.STATUS_OK && this.responseText === Constants.SUCCESS_REQUEST){									  
								    	reader = new FileReader();
									    reader.onload = (function(theFile) {
								        return function(e) {
								          Play.getId('userPicture').src =  e.target.result;		         
								        };
								      })(picture);		      
								      reader.readAsDataURL(picture);
								      localStorage.removeItem(Constants.LOCALSTORAGE_REQUEST_LOAD_PROFILE);	
								      notify.success('The picture has been changed successfully!!!');	
								}else if(this.status === Constants.STATUS_INTERNAL_SERVER_ERROR){
									    document.body.innerHTML = this.responseText;   
								}else{
									notify.danger(this.responseText);
								}									  
						  }							  
						}
						xhr.open('POST','/uploadPicture');				
						var formData = new FormData();
						formData.append('picture', picture);
						xhr.send(formData);
						xhr.timeout = Constants.TIME_OUT;
						xhr.ontimeout = function () {
							notify.danger('Time out!!!');	
							Play.getId('fileselect').disabled = false;
						}		    		
		    	} else {		    		
		    		 notify.danger('The image can be maximun of 64 KB');
		    	}		    	
		    } else {		    	
		    	notify.danger('The file not is a image valid!');
		    }			    
	  }	  
 /* ==================================================================================================================
 * REGION SAVE
 * ===================================================================================================================
 */		  
	 function save(){		 
		 frmUser.onsubmit = function(e){
			 e.preventDefault();
			 if(FormOk.hasChanged()){
				 if(frmUserOk.isValid()){				    						
						var xhr = new XMLHttpRequest();		
						xhr.onreadystatechange = function () {	
							  notify.wait('Loading...');	
							  btnSave.disabled = true;
							  if (this.readyState === Constants.READYSTATE_COMPLETE) {								  			
								  btnSave.disabled = false;
								  if(this.status === Constants.STATUS_OK  && this.responseText === Constants.SUCCESS_REQUEST){									  
									  localStorage.removeItem(Constants.LOCALSTORAGE_REQUEST_LOAD_PROFILE);
									  notify.success('Your User has been saved successfully!');								  
								   }else{
									   notify.danger(this.responseText); 
								   } 					  
							  }		  
						}
						xhr.open('POST','/saveUser');
						xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
						xhr.send(Play.serialize(e.target));		
						xhr.timeout = Constants.TIME_OUT;
						xhr.ontimeout = function () {
							 notify.danger('Time out!!!');
							 btnSave.disabled = false;
						}					 
				 }	
			 }else{
				 notify.warning('No changes to save!!!'); 
			 }		 
		 }			 
	}
/* ==================================================================================================================
 * REGION INIT
 * ===================================================================================================================
 */		
	function init(){		
	  loadList();
	  Nav.init();		
	  if(localStorage.getItem(Constants.LOCALSTORAGE_REQUEST_LOAD_PROFILE) == null){			  
		  load();
	  }else {
		  User = JSON.parse(localStorage.getItem(Constants.LOCALSTORAGE_REQUEST_LOAD_PROFILE)); 
		  fill(User);
	  }		  
	  uploadPicture();	
	  save();	  
	}
	

	  
	  
	  
	  
	  
	  
	  
	  
})
		  







