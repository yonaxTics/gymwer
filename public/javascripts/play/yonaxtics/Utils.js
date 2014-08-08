
/*
 * ========================================================================
 * Play Utils yonax73@gmail.com
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
/* ========================================================================
 * Version 0.1: 08-august-2014 
 * Created on : 08-august-2014
 * Author     : Yonatan Alexis Quintero Rodriguez
 * ========================================================================
 */
define(['./Constants'], function(Constants) {
	
	
	function Utils(){}
	
	

	
	
		
	Utils.padString = function(source){
		
	    var paddingChar = ' ';
	    var size = 16;
	    var x = source.length % size;
	    var padLength = size - x;
	    
	    for (var i = 0; i < padLength; i++) source += paddingChar;
	    
	    return source;
	}
	
	

	Utils.enc = function(plainText){
		
		var key = CryptoJS.enc.Latin1.parse(Constants.KEY);
		var iv  = CryptoJS.enc.Latin1.parse(Constants.IV);
		
		var padMsg = Utils.padString(plainText);

		return CryptoJS.AES.encrypt(padMsg, key, { iv: iv, padding: CryptoJS.pad.NoPadding, mode: CryptoJS.mode.CBC});
		
	}
	
	
	
	
	return Utils;
	
	
});