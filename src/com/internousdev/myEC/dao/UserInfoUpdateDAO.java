package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.util.DBConnector;

public class UserInfoUpdateDAO {

	public void userInfoUpdate(String dbUpdateField, String newValue, int userId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();


		try{

			String sql = "UPDATE user_info SET " + dbUpdateField + " = ? WHERE user_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, userId);

			preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}



