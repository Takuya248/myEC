package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.util.DBConnector;

public class UserInfoInsertDAO {



	public void infoInsert(String newLoginId, String newPassword, String newUserName, String newMailAddress){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "INSERT INTO user_info(login_id, login_pass, user_name, mail_add)VALUES(?,?,?,?)";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, newLoginId);
			preparedStatement.setString(2, newPassword);
			preparedStatement.setString(3, newUserName);
			preparedStatement.setString(4, newMailAddress);

			preparedStatement.execute();

		}catch(Exception e){
			e.printStackTrace();
		}

		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
