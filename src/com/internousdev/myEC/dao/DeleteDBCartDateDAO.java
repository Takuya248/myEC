package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.util.DBConnector;

public class DeleteDBCartDateDAO{

	public void deleteDBCartdata(int userId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		try{

			String sql = "DELETE FROM cartitem_info WHERE user_id= ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

			connection.close();

		}catch(SQLException e){
			e.printStackTrace();
		}

	}
}

