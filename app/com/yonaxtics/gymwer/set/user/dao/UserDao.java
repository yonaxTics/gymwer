package com.yonaxtics.gymwer.set.user.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import play.db.DB;

import com.yonaxtics.gymwer.set.user.entity.User;
import com.yonaxtics.gymwer.util.base.dao.Dao;
/**
 * 
 * @author yonatan quintero
 * @version 0.1 (7/16/2014)
 *
 */
public class UserDao extends Dao{

	
	public static boolean create(User user){		
		
		boolean result = false;
		
		CallableStatement cst = null;
		Connection conn = null;
		
		try {
			 
			 conn = DB.getConnection();			 
			 String sql = "CALL sp_set_user_CREATE(?,?,?);";			 
			 cst = conn.prepareCall(sql);
			 cst.registerOutParameter(1, Types.INTEGER);
			 cst.setString(2, user.getName());
			 cst.setString(3, user.getPassword());			 
			 
			 result = cst.executeUpdate() > 0;
			 
			 if(result) user.setId(cst.getInt(1));
			 
		} catch (Exception e) {
              
			e.printStackTrace();
			
		} finally{
			
			if(cst != null) cst = null;
			close(conn);
			
		}
		
		return result;
		
	}
	
	
}