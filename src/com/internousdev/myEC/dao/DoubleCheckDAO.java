package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.myEC.util.DBConnector;

public class DoubleCheckDAO {


	public boolean idSelect(String loginId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		boolean exist = true;

		String sql = "SELECT login_id FROM user_info WHERE login_id = ?";


		try{

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, loginId);
		ResultSet resultSet = preparedStatement.executeQuery();

		exist = resultSet.next();


		}catch(SQLException e){
			e.printStackTrace();
		}
		return exist;
	}



}
