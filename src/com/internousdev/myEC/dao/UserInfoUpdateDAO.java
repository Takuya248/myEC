package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.util.DBConnector;
import com.internousdev.myEC.util.DateUtil;

public class UserInfoUpdateDAO {

	public void userInfoUpdate(String dbUpdateField, String newValue, int userId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();


		try{

			String sql = "UPDATE user_info SET ? = ? , updeted_date = ? WHERE user_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dbUpdateField);
			preparedStatement.setString(2, newValue);
			preparedStatement.setString(3, dateUtil.getDate());
			preparedStatement.setInt(4, userId);

			preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}



