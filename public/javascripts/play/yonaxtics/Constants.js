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
	 * ALERTS CLASSES
	 */
	Constants.ALERT_SUCCESS = 'alert alert-success alert-dismissible';
	Constants.ALERT_INFO = 'alert alert-info alert-dismissible';
	Constants.ALERT_WARNING = 'alert alert-warning alert-dismissible';
	Constants.ALERT_DANGER = 'alert alert-danger alert-dismissible';
	
	Constants.ICO_COG_SPIN = 'fa fa-cog fa-spin fa-lg pull-left';
	Constants.ICO_SUCCESS = 'fa fa-check fa-lg pull-left';
	Constants.ICO_WARNING = 'fa fa-exclamation-triangle fa-lg pull-left';
	Constants.ICO_ERROR = 'fa fa-hand-o-right fa-lg pull-left';
	

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
	Constants.REQUEST_SUCCESS = '19880511';
	

	return Constants;

});