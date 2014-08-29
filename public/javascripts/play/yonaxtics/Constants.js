/*
 * ========================================================================
 * Play Constans yonax73@gmail.com
 * ========================================================================
 * Copyright 2014 yonaxTics, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the 'License'); you may not
 * use Constants file except in compliance with the License. You may obtain a copy of
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
/* ========================================================================
 * Version 0.1: 28-june-2014 
 * Created on : 28-june-2014
 * Author     : Yonatan Alexis Quintero Rodriguez
 * ========================================================================
 */

define([], function() {

	function Constants() {
	}
	



	/**
	 * DROP DOWN CLASSES
	 */
   
     Constants.DROP_DOWN_OPEN = 'dropdown open';
     Constants.DROP_DOWN = 'dropdown';
	
	/**
	 * UTILS CLASSES
	 */
	Constants.HIDDEN = 'hidden';
	Constants.SHOW = 'show';

	/**
	 * FORM CLASSES
	 */
	Constants.FORM_GROUP = 'form-group';
	Constants.HAS_SUCCESS = 'form-group has-success';
	Constants.HAS_ERROR = 'form-group has-error';
	Constants.TEXT_DANGER = 'show text-danger';
	
	/**
	 * STATES REQUEST
	 */
	Constants.REQUEST_SUCCESS = '19880511Y';
	Constants.REQUEST_BAD = '19880512Y'
	
	/**
	 * #7h32k132
	 * #3l c13l0
	 */
	Constants.KEY = '376833326b313332'	
	Constants.IV = '336c206331336c30';	
	
	
	
    /**
     * STATES MODULES
     */
	Constants.MASTER_VALUE_MODULE_PARENT =1;
	
	
	
	/**
	 * STATUS PLAY
	 */
	Constants.OK = 1;
	
	
	
	/**
	 * LOCALSTORAGE REQUEST
	 */
	Constants.LOCALSTORAGE_REQUEST_LOAD_NAV = 'LOCALSTORAGE_REQUEST_LOAD_NAV';
	Constants.LOCALSTORAGE_REQUEST_LOAD_PROFILE = 'LOCALSTORAGE_REQUEST_LOAD_PROFILE';
	
	
	
	/**
	 * SESSIONSTORAGE
	 */
	Constants.SESSIONSTORAGE_OK = 'SESSIONSTORAGE_OK';
	Constants.SESSIONSTORAGE_MESSAGE = 'SESSIONSTORAGE_MESSAGE';	
	Constants.SESSIONSTORAGE_OPEN_NAV = 'SESSIONSTORAGE_OPEN_NAV';
	
	
	/**
	 * DOM STORAGE
	 */
	Constants.DOM_STORAGE_TRUE = '1';
	Constants.DOM_STORAGE_FALSE = '0';
	
   /**
    * LISTS LOCAL STORAGE
    */	
	Constants.LOCALSTORAGE_LIST_URL = 'LOCALSTORAGE_LIST_URL';

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * XMLHTTPREQUEST READYSTATE
	 */
	Constants.READYSTATE_COMPLETE  = 4;
	
	
	/**
	 * XMLHTTPREQUEST STATUS
	 */
	Constants.STATUS_OK  = 200;	
	
	
	/**
	 * XMLHTTPREQUEST READY STATE
	 */
	Constants.TIME_OUT = 10000;		
	

	return Constants;

});
