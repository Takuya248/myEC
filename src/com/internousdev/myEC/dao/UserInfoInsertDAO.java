package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.util.DBConnector;

public class UserInfoInsertDAO {



	public void infoInsert(String newLoginId, String newPassword, String newUserName, String newMailAddress){

		DBConnector dbConnector = new DBConnector();
		Connection conn = dbConnector.getConnection();

		String sql = "INSERT INTO user_info(login_id, login_pass, user_name, mail_add)VALUES(?,?,?,?)";

		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newLoginId);
			ps.setString(2, newPassword);
			ps.setString(3, newUserName);
			ps.setString(5, newMailAddress);

			ps.execute();

		}catch(Exception e){
			e.printStackTrace();
		}

		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
